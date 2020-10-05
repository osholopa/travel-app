package com.example.travelapp.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;

@Controller
public class JourneyController {
	
	@Autowired
	private JourneyRepository journeyRepository;

	@GetMapping(value="/")
	public String journeyList(Model model) {
		List<Journey> journeys = journeyRepository.findAll();
		model.addAttribute("journeys", journeys);
		return "journeylist";
	}
	
	@GetMapping(value="/add")
	public String hello() {
		return "add";
	}
}
