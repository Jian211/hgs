package com.bitcamp.hgs.place.domain;

import java.sql.Timestamp;

public class Places {
	
	private int placeIdx;	// 추천 장소idx
	private int adminIdx;	// 관리자 회원 번호idx
	private String title;	// 추천 장소 이름
	private String subjectCategory;	// 추천 장소 카테고리
	private String affiliation;	// 추천장소 위치 지역 
	private String oldAddress;	// 구주소
	private String newAddress;	// 신주소
	private String latitude;	// 위도
	private String longitude;	// 경도
	private String homepage;	// 홈페이지 주소
	private String phone;	// 전화번호
	private String openTime;	// 오픈시간
	private int holiday;	// 휴일
	private Timestamp insertDate;	// 등록날짜
	private Timestamp updateDate;	// 수정날짜
	private int state;	// 폐점여부
	private String fileName;
	
	public Places() {}

	
	public Places(int placeIdx, int adminIdx, String title, String subjectCategory, String affiliation,
			String oldAddress, String newAddress, String latitude, String longitude, String homepage, String phone,
			String openTime, int holiday, Timestamp insertDate, Timestamp updateDate, int state, String fileName) {
		
		this.placeIdx = placeIdx;
		this.adminIdx = adminIdx;
		this.title = title;
		this.subjectCategory = subjectCategory;
		this.affiliation = affiliation;
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.homepage = homepage;
		this.phone = phone;
		this.openTime = openTime;
		this.holiday = holiday;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
		this.state = state;
		this.fileName = fileName;
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

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public int getHoliday() {
		return holiday;
	}

	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	

	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "Places [placeIdx=" + placeIdx + ", adminIdx=" + adminIdx + ", title=" + title + ", subjectCategory="
				+ subjectCategory + ", affiliation=" + affiliation + ", oldAddress=" + oldAddress + ", newAddress="
				+ newAddress + ", latitude=" + latitude + ", longitude=" + longitude + ", homepage=" + homepage
				+ ", phone=" + phone + ", openTime=" + openTime + ", holiday=" + holiday + ", insertDate=" + insertDate
				+ ", updateDate=" + updateDate + ", state=" + state + ", fileName=" + fileName + "]";
	}


	


	
	
	
	
}
