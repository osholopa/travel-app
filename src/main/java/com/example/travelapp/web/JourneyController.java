package com.example.travelapp.web;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;
import com.example.travelapp.domain.Picture;
import com.example.travelapp.domain.PictureRepository;

@Controller
public class JourneyController {
	@Autowired
	JourneyRepository journeyRepository;
	@Autowired
	PictureRepository pictureRepository;
	@Autowired
	private Path rootLocation;

	@GetMapping(value = "/")
	public String journeyList(Model model) {
		
		List<Journey> journeys = journeyRepository.findAll();
		List<Picture> pictures = new ArrayList();
		
		for(Journey journey: journeys) {
			if(journey.getPicture() == null) {
				pictures.add(new Picture());
			}
			pictures.add(journey.getPicture());
		}
		
		List<String> fileNames = pictures.stream()
				.map(picture -> this.rootLocation.resolve(picture.getName()))
				.map(path -> MvcUriComponentsBuilder
						.fromMethodName(JourneyController.class, "serveFile", path.getFileName().toString()).build()
						.toString())				
				.collect(Collectors.toList());
		
		model.addAttribute("files", fileNames);
		model.addAttribute("journeys", journeys);
		
		return "journeylist";
	}
	
	@GetMapping(value = "/addjourney")
	public String addJourney(Model model) {
		model.addAttribute("journey", new Journey());
		return "add";
	}

	@PostMapping(value = "/add")
	public String handleJourneyUpload(@RequestParam("file") MultipartFile file, Journey journey,
			RedirectAttributes redirectAttributes, Model model) throws Exception {
		
		if (file.getSize() == 0) {
			return "redirect:/addpic";
		}
		
		String imagePath = this.rootLocation.resolve(file.getOriginalFilename()).toString();
		
		journey.setPicture(new Picture(imagePath));
		Files.copy(file.getInputStream(), this.rootLocation.resolve(imagePath));
		
		journeyRepository.save(journey);
	
		return "redirect:/";
	}
	
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {

		Path file = this.rootLocation.resolve(filename);
		Resource resource = new UrlResource(file.toUri());

		return ResponseEntity
				.ok()
				.body(resource);	
	}

	

}
