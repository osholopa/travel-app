package com.example.travelapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.travelapp.domain.User;
import com.example.travelapp.domain.UserRepository;

//Journey JPA repository test
@ExtendWith(SpringExtension.class)
@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTests {
	@Autowired
	private UserRepository repository;
	//Delete all users and create admin user before each test
	@BeforeEach
	public void init() {
		repository.deleteAll();
		User user = new User("admin", "$2a$10$lN5xX8pSB5qqTiPcWV773e/aLb.N8CzFyz3m3hqA1A/gSArBFLKdO", "ADMIN");
		repository.save(user);
	}
	//Read test
	@Test
	public void findByUsernameShouldReturnOne() {
		User user = repository.findByUsername("admin");
		assertThat(user.getUsername()).isEqualTo("admin");
		assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	//Create test
	@Test
	public void createNewUser() {
		User newUser = new User("user", "$2a$10$gRmDr.nCFC/4cRhScQ.D1.L5/ili0Q0DkFK2SMAM4yi5iLOByW1pK", "USER");
		repository.save(newUser);
		assertThat(newUser.getId()).isNotNull();
	}
	//Delete test
	@Test
	public void deleteUser() {
		String id = repository.findByUsername("admin").getId();
		assertThat(id).isNotNull();
		repository.deleteById(id);
		assertThat(repository.findAll()).hasSize(0);
	}

}
