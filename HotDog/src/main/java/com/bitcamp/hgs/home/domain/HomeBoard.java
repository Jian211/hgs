package com.bitcamp.hgs.home.domain;


public class HomeBoard {
	private int boardIdx;			// idx
	private String title;			// 제목
	private String content;			// 내용
	private String createDate;		// 만든 시각
	private String fileName;		// 글 사진 정보
	private String profile;			// 사진
	private String name;			// 강아지 이름
	private int likes;				// 보드 좋아요 갯수
	private String tags; 			// 해시태그

	public HomeBoard() {}

	public HomeBoard(int boardIdx, String title, String content, String createDate, String fileName, String profile,
			String name, int likes, String tags) {
		this.boardIdx = boardIdx;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.fileName = fileName;
		this.profile = profile;
		this.name = name;
		this.likes = likes;
		this.tags = tags;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "HomeBoard [boardIdx=" + boardIdx + ", title=" + title + ", content=" + content + ", createDate="
				+ createDate + ", fileName=" + fileName + ", profile=" + profile + ", name=" + name + ", likes=" + likes
				+ ", tags=" + tags + "]";
	}
	
	
	
}
