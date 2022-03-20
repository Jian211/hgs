package com.bitcamp.hgs.board.domain;

import org.springframework.web.multipart.MultipartFile;

public class RegBoardInfo {
	
	private int memberIdx = 1;
	private String title;
	private String content;
	private MultipartFile photo;
	
	public RegBoardInfo() {}

	public RegBoardInfo(int memberIdx, String title, String content, MultipartFile photo) {
		super();
		this.memberIdx = memberIdx;
		this.title = title;
		this.content = content;
		this.photo = photo;
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
		return "RegBoardInfo [memberIdx=" + memberIdx + ", title=" + title + ", content=" + content + ", photo=" + photo
				+ "]";
	}
	
	public RegBoard getBoard() {
		
		return new RegBoard(title, content);
	}
	
	
}
