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
import com.example.travelapp.domain.User;
import com.example.travelapp.domain.UserRepository;

@SpringBootApplication
public class TravelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAppApplication.class, args);
	}

	@Bean
	@Profile("dev")
	public CommandLineRunner init(JourneyRepository repository, UserRepository urepository) {
		return (args) -> {
			repository.deleteAll();
			repository.save(new Journey("Loma pyynikillä", LocalDate.parse("2020-10-14"),
					new Picture("https://osholopa-travel-app.s3-eu-north-1.amazonaws.com/1604524616439-thaimaa.PNG"),
					"Testiloma thaimaassa", 3));

			urepository.deleteAll();
			User user1 = new User("user", "$2a$10$gRmDr.nCFC/4cRhScQ.D1.L5/ili0Q0DkFK2SMAM4yi5iLOByW1pK", "USER");
			urepository.save(user1);
			User user2 = new User("admin", "$2a$10$lN5xX8pSB5qqTiPcWV773e/aLb.N8CzFyz3m3hqA1A/gSArBFLKdO", "ADMIN");
			urepository.save(user2);
		};
	}

}
