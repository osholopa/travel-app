package com.example.travelapp.domain;

public class Picture {
	private String url;
	
	public Picture() {}
	
	public Picture( String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Picture [url=" + url + "]";
	}
}