package com.bitcamp.hgs.member.domain;

public class Hashtag {
	private int hashtagIdx;
	private String tag;

	public Hashtag() {}

	public Hashtag(int hashtagIdx, String tag) {
		this.hashtagIdx = hashtagIdx;
		this.tag = tag;
	}

	public int getHashtagIdx() {
		return hashtagIdx;
	}

	public void setHashtagIdx(int hashtagIdx) {
		this.hashtagIdx = hashtagIdx;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Hashtag [hashtagIdx=" + hashtagIdx + ", tag=" + tag + "]";
	}

	
	
}
