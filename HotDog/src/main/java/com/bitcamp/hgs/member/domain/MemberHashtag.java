package com.bitcamp.hgs.member.domain;

public class MemberHashtag {
	
	private int memberIdx;
	private int hashtagIdx;
	
	public MemberHashtag() {}

	public MemberHashtag(int memberIdx, int hashtagIdx) {
		this.memberIdx = memberIdx;
		this.hashtagIdx = hashtagIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public int getHashtagIdx() {
		return hashtagIdx;
	}

	public void setHashtagIdx(int hashtagIdx) {
		this.hashtagIdx = hashtagIdx;
	}

	@Override
	public String toString() {
		return "MemberHashtag [memberIdx=" + memberIdx + ", hashtagIdx=" + hashtagIdx + "]";
	}
	

	
}
