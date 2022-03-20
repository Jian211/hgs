package com.bitcamp.hgs.place.domain;

public class PlaceFiles {
	
	
	private int placeIdx;	// 추천 장소 idx
	private String fileName;	// 사진 파일 이름
	private int size;	// 사진 파일 사이즈
	
	public PlaceFiles() {}

	public PlaceFiles(int placeIdx, String fileName, int size) {
		
		this.placeIdx = placeIdx;
		this.fileName = fileName;
		this.size = size;
	}

	

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
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
		return "PlaceFiles [placeIdx=" + placeIdx + ", fileName=" + fileName
				+ ", size=" + size + "]";
	}
	
	
}
