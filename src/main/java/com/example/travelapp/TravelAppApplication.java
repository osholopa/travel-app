package com.example.travelapp;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;

@SpringBootApplication
public class TravelAppApplication implements CommandLineRunner {
	@Autowired
	private JourneyRepository journeyRepository;


	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}
	
	@Bean
	Path path(){
		return Paths.get(System.getProperty("java.io.tmpdir"));
	}
	
	@Override
	  public void run(String... args) throws Exception {
		
	  }
}
