package com.example.travelapp;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.travelapp.domain.Journey;
import com.example.travelapp.domain.JourneyRepository;
import com.example.travelapp.domain.Picture;

//Journey JPA repository test
@ExtendWith(SpringExtension.class)
@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JourneyRepositoryTests {
	@Autowired
	private JourneyRepository repository;

	@BeforeEach
	public void init() {
		repository.deleteAll();
		repository.save(new Journey("Testjourney", LocalDate.parse("2020-10-14"),
				new Picture("https://via.placeholder.com/225/225"), "Test journey for testing purposes", 3));
	}
	//Read test
	@Test
	public void findByTitleShouldReturnOne() {
		List<Journey> journeys = repository.findByTitle("Testjourney");
		assertThat(journeys).hasSize(1);
		assertThat(journeys.get(0).getDescription()).isEqualTo("Test journey for testing purposes");
	}
	//Create test
	@Test
	public void createNewJourney() {
		Journey journey = new Journey("Creating test", LocalDate.parse("2020-11-12"),
				new Picture("https://via.placeholder.com/225/225"), "Testing journey creation", 4);
		repository.save(journey);
		assertThat(journey.getId()).isNotNull();
	}
	//Delete test
	@Test
	public void deleteJourney() {
		String id = repository.findByTitle("Testjourney").get(0).getId();
		assertThat(id).isNotNull();
		repository.deleteById(id);
		assertThat(repository.findAll()).hasSize(0);
	}

}
