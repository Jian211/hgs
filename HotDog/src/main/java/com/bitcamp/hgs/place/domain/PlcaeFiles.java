package com.bitcamp.hgs.place.domain;

public class PlcaeFiles {
	
	private int placeFileIdx;	// 추천 장소 사진파일 idx
	private int placeIdx;	// 추천 장소 idx
	private String fileName;	// 사진 파일 이름
	private int size;	// 사진 파일 사이즈
	private String createDate;	// 등록날짜
	private String deleteDate;	// 삭제날짜
	private boolean exits;	// 삭제여부
	
	public PlcaeFiles(int placeFileIdx, int placeIdx, String fileName, int size, String createDate, String deleteDate,
			boolean exits) {
		
		this.placeFileIdx = placeFileIdx;
		this.placeIdx = placeIdx;
		this.fileName = fileName;
		this.size = size;
		this.createDate = createDate;
		this.deleteDate = deleteDate;
		this.exits = exits;
	}

	public int getPlaceFileIdx() {
		return placeFileIdx;
	}

	public void setPlaceFileIdx(int placeFileIdx) {
		this.placeFileIdx = placeFileIdx;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public boolean isExits() {
		return exits;
	}

	public void setExits(boolean exits) {
		this.exits = exits;
	}

	@Override
	public String toString() {
		return "PlcaeFiles [placeFileIdx=" + placeFileIdx + ", placeIdx=" + placeIdx + ", fileName=" + fileName
				+ ", size=" + size + ", createDate=" + createDate + ", deleteDate=" + deleteDate + ", exits=" + exits
				+ "]";
	}
	
	
	
}
