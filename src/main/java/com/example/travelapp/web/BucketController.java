 package com.example.travelapp.web;

import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;
import com.example.travelapp.domain.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/storage/")
public class BucketController {
	
	@Autowired
	JourneyRepository journeyRepository;

    private AmazonClient amazonClient;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }
    
    //User feature to post journey entries to DB and their images to AWS
    @PostMapping("/uploadFile")
    public String uploadFileProd(@RequestParam("file") MultipartFile file, Journey journey) {
        String imageUrl = this.amazonClient.uploadFile(file);
        journey.setPicture(new Picture(imageUrl));
        //journey.setPicture(new Picture("https://via.placeholder.com/225/225"));
    	journeyRepository.save(journey); 	
		return "redirect:/";
    }
    
    //Admin feature to delete entries
    @GetMapping("/deleteJourney/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteJourney(@PathVariable("id") String id, Model model) {
    	Journey journey = journeyRepository.findById(id).get();
        this.amazonClient.deleteFileFromS3Bucket(journey.getPicture().getUrl());
        journeyRepository.deleteById(id);
        return "redirect:/";
    }
}