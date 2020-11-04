package com.example.travelapp.domain;

import org.springframework.data.annotation.Id;


public class Picture {
	@Id
	private Long pictureId;
	private String url;
	
	public Picture() {}
	
	public Picture( String url) {
		this.url = url;
	}

	public Long getPictureId() {
		return pictureId;
	}

	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Picture [pictureId=" + pictureId + ", url=" + url + "]";
	}
}