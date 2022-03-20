package com.bitcamp.hgs.home.domain;

public class HomePlaces {
	private int placeIdx;			// idx
	private String title;			// 제목
	private String subjectCategory; // 카테고리
	private String newAddress;		// 주소

	public HomePlaces() {}

	public HomePlaces(int placeIdx, String title, String subjectCategory, String newAddress) {
		this.placeIdx = placeIdx;
		this.title = title;
		this.subjectCategory = subjectCategory;
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

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	@Override
	public String toString() {
		return "HomePlaces [placeIdx=" + placeIdx + ", title=" + title + ", subjectCategory=" + subjectCategory
				+ ", newAddress=" + newAddress + "]";
	}

	
}
