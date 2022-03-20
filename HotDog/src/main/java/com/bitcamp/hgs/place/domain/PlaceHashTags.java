package com.bitcamp.hgs.place.domain;

public class PlaceHashTags {
	
	private int hashtag_idx;	// 해시태그 idx
	private int place_idx;	// 추천 장소 idx
	
	public PlaceHashTags(int hashtag_idx, int place_idx) {
		
		this.hashtag_idx = hashtag_idx;
		this.place_idx = place_idx;
	}

	public int getHashtag_idx() {
		return hashtag_idx;
	}

	public void setHashtag_idx(int hashtag_idx) {
		this.hashtag_idx = hashtag_idx;
	}

	public int getPlace_idx() {
		return place_idx;
	}

	public void setPlace_idx(int place_idx) {
		this.place_idx = place_idx;
	}

	@Override
	public String toString() {
		return "PlcaeHashTags [hashtag_idx=" + hashtag_idx + ", place_idx=" + place_idx + "]";
	}
	
	
}
