package com.example.travelapp.domain;

import org.springframework.data.annotation.Id;

public class Journey {
	@Id
	private String id;
	private String title;
	private Picture picture;
	
	public Journey() {
		super();
	}
	
	public Journey(String title, Picture picture) {
		super();
		this.title = title;
		this.picture = picture;
	}
	
	public Journey(String title) {
		super();
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", title=" + title + ", picture=" + picture + "]";
	}
	
}
