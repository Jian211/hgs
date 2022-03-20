package com.bitcamp.hgs.board.domain;

public class BoardFiles {
	
	
	private int boardIdx;	// 추천 장소 idx
	private String fileName;	// 사진 파일 이름
	private int size;	// 사진 파일 사이즈
	
	public BoardFiles() {}

	public BoardFiles(int boardIdx, String fileName, int size) {
		
		this.boardIdx = boardIdx;
		this.fileName = fileName;
		this.size = size;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "BoardFiles [boardIdx=" + boardIdx + ", fileName=" + fileName + ", size=" + size + "]";
	}

	
	
	
}
