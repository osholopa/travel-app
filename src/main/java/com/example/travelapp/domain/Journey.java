package com.example.travelapp.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

public class Journey {
	@Id
	private String id;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private String comment;
	private int grade;

	public Journey(String title, LocalDate startDate, LocalDate endDate, String comment, int grade) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.grade = grade;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", grade=" + grade + "]";
	}
}
