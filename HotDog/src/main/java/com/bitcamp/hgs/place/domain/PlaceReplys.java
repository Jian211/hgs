package com.bitcamp.hgs.place.domain;

import java.sql.Timestamp;

public class PlaceReplys {
	
	private int placeReplyIdx;	// 추천 장소 댓글 idx
	private int placeIdx;		// 추천 장소 idx
	private int memberIdx = 1;		// 일반 회원 idx
	private int star;			// 별점 
	private String content;		// 추천 장소 댓글 내용
	private String fileName;	// 파일 이름
	private Timestamp createDate;	// 작성날짜
	private Timestamp editDate;	// 수정날짜
	
	public PlaceReplys() {}
	
	public PlaceReplys(int placeReplyIdx, int placeIdx, int memberIdx, int star, String content, String fileName,
			Timestamp createDate, Timestamp editDate) {
		
		this.placeReplyIdx = placeReplyIdx;
		this.placeIdx = placeIdx;
		this.memberIdx = memberIdx;
		this.star = star;
		this.content = content;
		this.fileName = fileName;
		this.createDate = createDate;
		this.editDate = editDate;
	}

	public int getPlaceReplyIdx() {
		return placeReplyIdx;
	}

	public void setPlaceReplyIdx(int placeReplyIdx) {
		this.placeReplyIdx = placeReplyIdx;
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

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getEditDate() {
		return editDate;
	}

	public void setEditDate(Timestamp editDate) {
		this.editDate = editDate;
	}

	@Override
	public String toString() {
		return "PlaceReplys [placeReplyIdx=" + placeReplyIdx + ", placeIdx=" + placeIdx + ", memberIdx=" + memberIdx
				+ ", star=" + star + ", content=" + content + ", fileName=" + fileName + ", createDate=" + createDate
				+ ", editDate=" + editDate + "]";
	}
	
	
	
	

	
}
