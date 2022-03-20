package com.bitcamp.hgs.place.domain;

public class RegPlace {

	private int placeIdx;
	private int adminIdx = 1; // 관리자 회원 번호idx
	private String title; // 추천 장소 이름
	private String subjectCategory; // 추천 장소 카테고리
	private String affiliation; // 추천장소 위치 지역
	private String oldAddress;
	private String newAddress; // 신주소
	private String homepage; // 홈페이지 주소
	private String phone; // 전화번호

	public RegPlace() {
	}

	public RegPlace(String title, String subjectCategory, String affiliation, String oldAddress, String newAddress,
			String homepage, String phone) {

		this.title = title;
		this.subjectCategory = subjectCategory;
		this.affiliation = affiliation;
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
		this.homepage = homepage;
		this.phone = phone;

	}

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
	}

	public int getAdminIdx() {
		return adminIdx;
	}

	public void setAdminIdx(int adminIdx) {
		this.adminIdx = adminIdx;
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

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getOldAddress() {
		return oldAddress;
	}

	public void setOldAddress(String oldAddress) {
		this.oldAddress = oldAddress;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "RegPlace [adminIdx=" + adminIdx + ", title=" + title + ", subjectCategory=" + subjectCategory
				+ ", affiliation=" + affiliation + ", oldAddress=" + oldAddress + ", newAddress=" + newAddress
				+ ", homepage=" + homepage + ", phone=" + phone + "]";
	}

}
