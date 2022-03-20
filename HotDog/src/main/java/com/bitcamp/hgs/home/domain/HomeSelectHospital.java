package com.bitcamp.hgs.home.domain;

public class HomeSelectHospital extends HomeSelectPlace{
	private int hospitalIdx;			// idx
	private String hTitle;			// 제목
	private String hSubjectCategory; // 카테고리
	private String hFileName;
	private String hNewAddress;		// 주소
	private String hHashtags;
	private int hScrapIdx;		// 맴버 아이디로 스크랩 유무 확인

	public HomeSelectHospital() {	}

	public HomeSelectHospital(int hospitalIdx, String hTitle, String hSubjectCategory, String hFileName,
			String hNewAddress, String hHashtags, int hScrapIdx) {
		super();
		this.hospitalIdx = hospitalIdx;
		this.hTitle = hTitle;
		this.hSubjectCategory = hSubjectCategory;
		this.hFileName = hFileName;
		this.hNewAddress = hNewAddress;
		this.hHashtags = hHashtags;
		this.hScrapIdx = hScrapIdx;
	}

	public int getHospitalIdx() {
		return hospitalIdx;
	}

	public void setHospitalIdx(int hospitalIdx) {
		this.hospitalIdx = hospitalIdx;
	}

	public String gethTitle() {
		return hTitle;
	}

	public void sethTitle(String hTitle) {
		this.hTitle = hTitle;
	}

	public String gethSubjectCategory() {
		return hSubjectCategory;
	}

	public void sethSubjectCategory(String hSubjectCategory) {
		this.hSubjectCategory = hSubjectCategory;
	}

	public String gethFileName() {
		return hFileName;
	}

	public void sethFileName(String hFileName) {
		this.hFileName = hFileName;
	}

	public String gethNewAddress() {
		return hNewAddress;
	}

	public void sethNewAddress(String hNewAddress) {
		this.hNewAddress = hNewAddress;
	}

	public String gethHashtags() {
		return hHashtags;
	}

	public void sethHashtags(String hHashtags) {
		this.hHashtags = hHashtags;
	}

	public int gethScrapIdx() {
		return hScrapIdx;
	}

	public void sethScrapIdx(int hScrapIdx) {
		this.hScrapIdx = hScrapIdx;
	}

	@Override
	public String toString() {
		return "HomeSelectHospital [hospitalIdx=" + hospitalIdx + ", hTitle=" + hTitle + ", hSubjectCategory="
				+ hSubjectCategory + ", hFileName=" + hFileName + ", hNewAddress=" + hNewAddress + ", hHashtags="
				+ hHashtags + ", hScrapIdx=" + hScrapIdx + "]";
	}
	
}
