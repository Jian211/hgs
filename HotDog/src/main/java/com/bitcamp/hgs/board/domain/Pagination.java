package com.bitcamp.hgs.board.domain;

public class Pagination {

	private int pageNum;
	private int totalPageCount;
	private int numOfDisplayPageNum;
	private int startNum;
	private int endNum;
	private int preNum;
	private int nextNum;
	
	public Pagination(int pageNum, int totalPageCount, int numOfDisplayPageNum) {
		this.pageNum = pageNum;
		this.totalPageCount = totalPageCount;
		this.numOfDisplayPageNum = numOfDisplayPageNum;
		calPagination();
	}
	
	private void calPagination() {
		if(totalPageCount>0) {
			startNum = (pageNum-1)/numOfDisplayPageNum*numOfDisplayPageNum + 1;
			endNum = startNum + numOfDisplayPageNum -1;
			endNum = endNum > totalPageCount ? totalPageCount : endNum;
			preNum = startNum-1 < numOfDisplayPageNum ? 0 : startNum-1;
			nextNum = endNum == totalPageCount ? 0 : endNum+1; 
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getNumOfDisplayPageNum() {
		return numOfDisplayPageNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public int getPreNum() {
		return preNum;
	}

	public int getNextNum() {
		return nextNum;
	}
	
	
}
