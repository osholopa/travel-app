package com.example.travelapp.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;
import com.example.travelapp.domain.Picture;

@Controller
public class JourneyController {
	@Autowired
	JourneyRepository journeyRepository;

	// Get all entries from DB, collect their image urls to a list and add both as
	// lists to template
	@GetMapping(value = "/")
	public String journeyList(Model model) {

		List<Journey> journeys = journeyRepository.findAll();
		List<Picture> pictures = new ArrayList<Picture>();

		for (Journey journey : journeys) {
			if (journey.getPicture() == null) {
				pictures.add(new Picture());
			}
			pictures.add(journey.getPicture());
		}

		List<String> fileNames = pictures.stream().map(picture -> picture.getUrl()).collect(Collectors.toList());

		model.addAttribute("files", fileNames);
		model.addAttribute("journeys", journeys);

		return "journeylist";
	}

	// Add form - endpoint requires authentication
	@GetMapping(value = "/addjourney")
	public String addJourney(Model model) {
		model.addAttribute("journey", new Journey());
		return "add";
	}

}
