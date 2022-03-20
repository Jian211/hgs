package com.bitcamp.hgs.board.domain;

import java.util.List;


public class BoardListView {

	private List<BoardListMessage> list;
	private int totalCount;
	private Pagination pagination;
	private int pageNum;
	
	public BoardListView(int pageNum, int numOfDisplayMessage, int numOfDisplayPageNum,
			List<BoardListMessage> list, int totalCount) {
		this.pageNum = pageNum;
		this.list = list;
		this.totalCount = totalCount;
		
		pagination = new Pagination(pageNum, calTotalPageCount(numOfDisplayMessage, numOfDisplayPageNum);
	}
	private int calTotalPageCount(int numOfDisplayMessage) {
		int totalpageCount = totalCount / numOfDisplayMessage;
		totalpageCount = totalCount % numOfDisplayMessage > 0 ? ++totalpageCount : totalCount / numOfDisplayMessage;
		return totalpageCount;
	}
	public List<BoardListMessage> getList(){
		return list;
	}
	public void setList(List<BoardListMessage> list) {
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		return "BoardListView [list=" + list + ", totalCount=" + totalCount + ", pageNum=" + pageNum + "]";
	}
}
