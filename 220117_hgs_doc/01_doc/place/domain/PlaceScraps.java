package com.bitcamp.hgs.place.domain;

public class PlaceScraps {
	
	private int place_idx;	// 추천 장소 idx
	private int member_idx;	// 일반 회원 idx
	
	public PlaceScraps(int place_idx, int member_idx) {
		
		this.place_idx = place_idx;
		this.member_idx = member_idx;
	}

	public int getPlace_idx() {
		return place_idx;
	}

	public void setPlace_idx(int place_idx) {
		this.place_idx = place_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	@Override
	public String toString() {
		return "PlaceScraps [place_idx=" + place_idx + ", member_idx=" + member_idx + "]";
	}	
	
	
}
