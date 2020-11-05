package com.example.travelapp;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;
import com.example.travelapp.domain.Picture;

@SpringBootApplication
public class TravelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}

	@Bean
	@Profile("dev")
	public CommandLineRunner init(JourneyRepository repository) {
		return (args) -> {
			repository.deleteAll();
			repository.save(new Journey("Loma pyynikillä", LocalDate.parse("2020-10-14"),
					new Picture("https://osholopa-travel-app.s3.eu-north-1.amazonaws.com/1604520516125-pyynikki.jpg"),
					"Syntymäpäiviä viettämässä pyynikinharjulla", 5));
		};
	}

}
