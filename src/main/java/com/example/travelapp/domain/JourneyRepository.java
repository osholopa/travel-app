package com.example.travelapp.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JourneyRepository extends MongoRepository<Journey, String> {

  public List<Journey> findByTitle(String title);

}