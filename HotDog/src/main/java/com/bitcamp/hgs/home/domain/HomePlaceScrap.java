package com.bitcamp.hgs.home.domain;

public class HomePlaceScrap {
	private int placeIdx;
	private String title;
	private String latitude;
	private String longitude;
	private String newAddress;
	
	public HomePlaceScrap() {}

	public HomePlaceScrap(int placeIdx, String title, String latitude, String longitude, String newAddress) {
		this.placeIdx = placeIdx;
		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
		this.newAddress = newAddress;
	}

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	@Override
	public String toString() {
		return "PlaceScrap [placeIdx=" + placeIdx + ", title=" + title + ", latitude=" + latitude + ", longitude="
				+ longitude + ", newAddress=" + newAddress + "]";
	}

	
	
}
