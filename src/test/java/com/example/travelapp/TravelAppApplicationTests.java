package com.example.travelapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.travelapp.web.BucketController;
import com.example.travelapp.web.JourneyController;
import com.example.travelapp.web.LoginController;

//Smoke testing

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TravelAppApplicationTests {
	
	@Autowired
	private LoginController loginController;
	@Autowired
	private JourneyController journeyController;
	@Autowired
	private BucketController bucketController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(loginController).isNotNull();
		assertThat(journeyController).isNotNull();
		assertThat(bucketController).isNotNull();
	}

}
