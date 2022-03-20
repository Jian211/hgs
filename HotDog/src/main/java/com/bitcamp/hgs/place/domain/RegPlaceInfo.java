package com.bitcamp.hgs.place.domain;

import org.springframework.web.multipart.MultipartFile;

public class RegPlaceInfo {
	
	
	private int adminIdx = 1;	// 관리자 회원 번호idx
	private String title;	// 추천 장소 이름
	private String subjectCategory;	// 추천 장소 카테고리
	private String affiliation;	// 추천장소 위치 지역 
	private String oldAddress;	// 구주소
	private String newAddress;	// 신주소
	private String homepage;	// 홈페이지 주소
	private String phone;	// 전화번호
	private MultipartFile photo;
	
	public RegPlaceInfo() {	}

	public RegPlaceInfo(int adminIdx, String title, String subjectCategory, String affiliation,
			String oldAddress, String newAddress, String homepage, String phone, MultipartFile photo) {
		
		this.adminIdx = adminIdx;
		this.title = title;
		this.subjectCategory = subjectCategory;
		this.affiliation = affiliation;
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
		this.homepage = homepage;
		this.phone = phone;
		this.photo = photo;
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

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	

	public String getOldAddress() {
		return oldAddress;
	}

	public void setOldAddress(String oldAddress) {
		this.oldAddress = oldAddress;
	}

	@Override
	public String toString() {
		return "RegPlaceInfo [adminIdx=" + adminIdx + ", title=" + title
				+ ", subjectCategory=" + subjectCategory + ", affiliation=" + affiliation + ", oldAddress=" + oldAddress
				+ ", newAddress=" + newAddress + ", homepage=" + homepage + ", phone=" + phone + ", photo=" + photo
				+ "]";
	}

	
	public RegPlace getPlace() {
		
		return new RegPlace(title, subjectCategory, affiliation, oldAddress,newAddress, homepage, phone);
	}
	
	
	
}
