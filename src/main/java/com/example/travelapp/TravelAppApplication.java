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
			//Delete all database entries
			repository.deleteAll();
			//Create a placeholder entry
			repository.save(new Journey("Placeholder journey", LocalDate.parse("2020-10-14"),
					new Picture("https://via.placeholder.com/225/225"),
					"Placeholder journey with placeholder img", 3));

			//Delete all database user entries and create a couple of users
			urepository.deleteAll();
			User user1 = new User("user", "$2a$10$YFMA9xzqQg67RorPDo3bkO/BDfEOpT9J1lm3ex86GiNatR0hgqxSi", "USER");
			urepository.save(user1);
			User user2 = new User("admin", "$2a$10$hqzO5aZYD5lHSvT7o59s9.ZPuNP6m1RoI.7G.CMGzpOwiJuhUq2Ze", "ADMIN");
			urepository.save(user2);
		};
	}

}
