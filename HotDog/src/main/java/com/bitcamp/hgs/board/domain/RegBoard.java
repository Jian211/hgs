package com.bitcamp.hgs.board.domain;

import org.springframework.web.multipart.MultipartFile;

public class RegBoard {

	private int boardIdx;
	private int memberIdx = 1;
	private String title;
	private String content;
	private MultipartFile photo;

	public RegBoard() {
	}

	

	public RegBoard(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}



	public int getBoardIdx() {
		return boardIdx;
	}



	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}



	public int getMemberIdx() {
		return memberIdx;
	}



	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public MultipartFile getPhoto() {
		return photo;
	}



	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}



	@Override
	public String toString() {
		return "RegBoard [boardIdx=" + boardIdx + ", memberIdx=" + memberIdx + ", title=" + title + ", content="
				+ content + ", photo=" + photo + "]";
	}



	
}
