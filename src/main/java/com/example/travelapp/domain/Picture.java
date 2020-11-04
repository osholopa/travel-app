package com.example.travelapp.domain;

import org.springframework.data.annotation.Id;


public class Picture {
	@Id
	private Long pictureId;
	private String name;
	
	public Picture() {}
	
	public Picture( String name) {
		this.name = name;
	}

	public Long getPictureId() {
		return pictureId;
	}

	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Picture [pictureId=" + pictureId + ", name=" + name + "]";
	}

	

	

	
}