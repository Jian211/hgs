package com.bitcamp.hgs.place.domain;

public class PlaceScraps {
	
	private int placeIdx;	// 추천 장소 idx
	private int memberIdx;	// 일반 회원 idx
	
	
	public PlaceScraps() {}
	
	
	public PlaceScraps(int placeIdx, int memberIdx) {
		
		this.placeIdx = placeIdx;
		this.memberIdx = memberIdx;
	}

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	@Override
	public String toString() {
		return "PlaceScraps [placeIdx=" + placeIdx + ", memberIdx=" + memberIdx + "]";
	}	
	
	
}
