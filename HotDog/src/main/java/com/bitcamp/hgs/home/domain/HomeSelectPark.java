package com.bitcamp.hgs.home.domain;

public class HomeSelectPark extends HomeSelectPlace{
	private int parkIdx;			// idx
	private String pTitle;			// 제목
	private String pSubjectCategory; // 카테고리
	private String pFileName;
	private String pNewAddress;		// 주소
	private String pHashtags;
	private int pScrapIdx;		// 맴버 아이디로 스크랩 유무 확인
	
	public HomeSelectPark() {	}

	public HomeSelectPark(int parkIdx, String pTitle, String pSubjectCategory, String pFileName, String pNewAddress,
			String pHashtags, int pScrapIdx) {
		this.parkIdx = parkIdx;
		this.pTitle = pTitle;
		this.pSubjectCategory = pSubjectCategory;
		this.pFileName = pFileName;
		this.pNewAddress = pNewAddress;
		this.pHashtags = pHashtags;
		this.pScrapIdx = pScrapIdx;
	}

	public int getParkIdx() {
		return parkIdx;
	}

	public void setParkIdx(int parkIdx) {
		this.parkIdx = parkIdx;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpSubjectCategory() {
		return pSubjectCategory;
	}

	public void setpSubjectCategory(String pSubjectCategory) {
		this.pSubjectCategory = pSubjectCategory;
	}

	public String getpFileName() {
		return pFileName;
	}

	public void setpFileName(String pFileName) {
		this.pFileName = pFileName;
	}

	public String getpNewAddress() {
		return pNewAddress;
	}

	public void setpNewAddress(String pNewAddress) {
		this.pNewAddress = pNewAddress;
	}

	public String getpHashtags() {
		return pHashtags;
	}

	public void setpHashtags(String pHashtags) {
		this.pHashtags = pHashtags;
	}

	public int getpScrapIdx() {
		return pScrapIdx;
	}

	public void setpScrapIdx(int pScrapIdx) {
		this.pScrapIdx = pScrapIdx;
	}

	@Override
	public String toString() {
		return "HomeSelectPark [parkIdx=" + parkIdx + ", pTitle=" + pTitle + ", pSubjectCategory=" + pSubjectCategory
				+ ", pFileName=" + pFileName + ", pNewAddress=" + pNewAddress + ", pHashtags=" + pHashtags
				+ ", pScrapIdx=" + pScrapIdx + "]";
	}
	
}
