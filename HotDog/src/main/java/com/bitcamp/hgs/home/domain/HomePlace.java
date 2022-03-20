package com.bitcamp.hgs.home.domain;

public class HomePlace {
	private int placeIdx;			// 추천 장소idx
	private String title;			// 추천 장소 이름
	private String subjectCategory; // 카페,병원,공원

	public HomePlace() {}

	public HomePlace(int placeIdx, String title, String subjectCategory) {
		this.placeIdx = placeIdx;
		this.title = title;
		this.subjectCategory = subjectCategory;
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

	@Override
	public String toString() {
		return "HomePlace [placeIdx=" + placeIdx + ", title=" + title + ", subjectCategory=" + subjectCategory + "]";
	}

	
	
}
