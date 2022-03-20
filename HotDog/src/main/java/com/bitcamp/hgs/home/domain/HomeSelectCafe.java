package com.bitcamp.hgs.home.domain;

public class HomeSelectCafe extends HomeSelectPlace{
	private int cafeIdx;			// idx
	private String cTitle;			// 제목
	private String cSubjectCategory; // 카테고리
	private String cFileName;
	private String cNewAddress;		// 주소
	private String cHashtags;
	private int cScrapIdx;		// 맴버 아이디로 스크랩 유무 확인
	
	public HomeSelectCafe() {	}

	public HomeSelectCafe(int cafeIdx, String cTitle, String cSubjectCategory, String cFileName, String cNewAddress,
			String cHashtags, int cScrapIdx) {
		this.cafeIdx = cafeIdx;
		this.cTitle = cTitle;
		this.cSubjectCategory = cSubjectCategory;
		this.cFileName = cFileName;
		this.cNewAddress = cNewAddress;
		this.cHashtags = cHashtags;
		this.cScrapIdx = cScrapIdx;
	}

	public int getCafeIdx() {
		return cafeIdx;
	}

	public void setCafeIdx(int cafeIdx) {
		this.cafeIdx = cafeIdx;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcSubjectCategory() {
		return cSubjectCategory;
	}

	public void setcSubjectCategory(String cSubjectCategory) {
		this.cSubjectCategory = cSubjectCategory;
	}

	public String getcFileName() {
		return cFileName;
	}

	public void setcFileName(String cFileName) {
		this.cFileName = cFileName;
	}

	public String getcNewAddress() {
		return cNewAddress;
	}

	public void setcNewAddress(String cNewAddress) {
		this.cNewAddress = cNewAddress;
	}

	public String getcHashtags() {
		return cHashtags;
	}

	public void setcHashtags(String cHashtags) {
		this.cHashtags = cHashtags;
	}

	public int getcScrapIdx() {
		return cScrapIdx;
	}

	public void setcScrapIdx(int cScrapIdx) {
		this.cScrapIdx = cScrapIdx;
	}

	@Override
	public String toString() {
		return "HomeSelectCafe [cafeIdx=" + cafeIdx + ", cTitle=" + cTitle + ", cSubjectCategory=" + cSubjectCategory
				+ ", cFileName=" + cFileName + ", cNewAddress=" + cNewAddress + ", cHashtags=" + cHashtags
				+ ", cScrapIdx=" + cScrapIdx + "]";
	}

	
	
}
