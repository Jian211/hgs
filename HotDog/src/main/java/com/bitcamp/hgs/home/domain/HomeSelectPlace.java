package com.bitcamp.hgs.home.domain;

public class HomeSelectPlace {
	private int placeIdx;			// idx
	private String title;			// 제목
	private String subjectCategory; // 카테고리
	private String fileName;
	private String newAddress;		// 주소
	private String hashtags;
	private int scrapIdx;		// 맴버 아이디로 스크랩 유무 확인

	public HomeSelectPlace() {	}

	public HomeSelectPlace(int placeIdx, String title, String subjectCategory, String fileName, String newAddress,
			String hashtags, int scrapIdx) {
		this.placeIdx = placeIdx;
		this.title = title;
		this.subjectCategory = subjectCategory;
		this.fileName = fileName;
		this.newAddress = newAddress;
		this.hashtags = hashtags;
		this.scrapIdx = scrapIdx;
	}
	
	public HomeSelectCafe getCafe() {
		return new HomeSelectCafe(placeIdx, title, subjectCategory, fileName, newAddress, hashtags, scrapIdx);
	}
	public HomeSelectHospital getHospital() {
		return new HomeSelectHospital(placeIdx, title, subjectCategory, fileName, newAddress, hashtags, scrapIdx);
	}
	public HomeSelectPark getPark() {
		return new HomeSelectPark(placeIdx, title, subjectCategory, fileName, newAddress, hashtags, scrapIdx);
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public int getScrapIdx() {
		return scrapIdx;
	}

	public void setScrapIdx(int scrapIdx) {
		this.scrapIdx = scrapIdx;
	}

	@Override
	public String toString() {
		return "HomeSelectPlace [placeIdx=" + placeIdx + ", title=" + title + ", subjectCategory=" + subjectCategory
				+ ", fileName=" + fileName + ", newAddress=" + newAddress + ", hashtags=" + hashtags + ", scrapIdx="
				+ scrapIdx + "]";
	}
	
	
}
