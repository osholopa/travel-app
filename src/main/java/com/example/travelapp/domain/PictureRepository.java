package com.example.travelapp.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PictureRepository extends MongoRepository<Picture, Long>{

	 Picture findByName(String name);
	 
}
