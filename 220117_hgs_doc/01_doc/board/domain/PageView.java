package com.bitcamp.hgs.board.domain;

public class PageView {

	private int board_idx;
	private String title;
	private String content;
	private String create_date;
	private String edit_date;
	private String delete_date;
	private int exist;
	
	public PageView(int board_idx, String title, String content, String create_date, String edit_date, String delete_date,
			int exist) {
		super();
		this.board_idx = board_idx;
		this.title = title;
		this.content = content;
		this.create_date = create_date;
		this.edit_date = edit_date;
		this.delete_date = delete_date;
		this.exist = exist;
	}
	
	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
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
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	public String getDelete_date() {
		return delete_date;
	}
	public void setDelete_date(String delete_date) {
		this.delete_date = delete_date;
	}
	public int getExist() {
		return exist;
	}
	public void setExist(int exist) {
		this.exist = exist;
	}
	@Override
	public String toString() {
		return "PageView [board_idx=" + board_idx + ", title=" + title + ", content=" + content + ", create_date=" + create_date
				+ ", edit_date=" + edit_date + ", delete_date=" + delete_date + ", exist=" + exist + "]";
	}
}
