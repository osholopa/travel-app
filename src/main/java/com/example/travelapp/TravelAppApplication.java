package com.example.travelapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;

@SpringBootApplication
public class TravelAppApplication implements CommandLineRunner {
	@Autowired
	private JourneyRepository journeyRepository;

	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}
	
	@Override
	  public void run(String... args) throws Exception {

		journeyRepository.deleteAll();

	    // save a couple of journeys
		journeyRepository.save(new Journey("Veneretki saimaalla", LocalDate.of(2020, 6, 14), LocalDate.of(2020, 6, 14), "Kivaa oli", 4));

	    // fetch all customers
	    System.out.println("Journeys found with findAll():");
	    System.out.println("-------------------------------");
	    for (Journey journey: journeyRepository.findAll()) {
	      System.out.println(journey);
	    }
	    System.out.println();
	  }

}
