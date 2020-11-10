package com.example.travelapp.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class Journey {
	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private int grade;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private Picture picture;
	
	public Journey() {
		super();
	}

	public Journey(String title, LocalDate date, Picture picture, String description, int grade) {
		super();
		this.title = title;
		this.date = date;
		this.picture = picture;	
		this.description = description;	
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Journey(String title) {
		super();
		this.title = title;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
		return "Journey [id=" + id + ", title=" + title + ", date=" + date + ", picture=" + picture + "]";
	}

	
}
