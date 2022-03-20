package com.bitcamp.hgs.place.domain;

import java.util.List;


public class PlaceListView {

	private List<Places> list;
	private int totalCount;
	private Pagination pagination;
	private int pageNum;
	
	public PlaceListView(int pageNum, int numOfDisplayMessage, int numOfDisplayPageNum,
			List<Places> list, int totalCount) {
		this.pageNum = pageNum;
		this.list = list;
		this.totalCount = totalCount;

		pagination = new Pagination(pageNum, calTotalPageCount(numOfDisplayMessage), numOfDisplayPageNum);
	}
	
	private int calTotalPageCount(int numOfDisplayMessage) {
		int totalpageCount = totalCount / numOfDisplayMessage;
		totalpageCount = totalCount % numOfDisplayMessage > 0 ? ++totalpageCount : totalCount / numOfDisplayMessage;
		return totalpageCount;
	}

	public List<Places> getList() {
		return list;
	}

	public void setList(List<Places> list) {
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
		return "PlaceListView [list=" + list + ", totalCount=" + totalCount + ", pagination=" + pagination
				+ ", pageNum=" + pageNum + "]";
	}
	
	
	
}
