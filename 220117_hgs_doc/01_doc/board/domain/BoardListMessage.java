package com.bitcamp.hgs.board.domain;



public class BoardListMessage {

	private int board_idx;
	private String title;
	private String content;
	private int exist;
	
	private String create_String;
	private String delete_String;
	private String edit_String;
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
	public int getExist() {
		return exist;
	}
	public void setExist(int exist) {
		this.exist = exist;
	}
	public String getCreate_String() {
		return create_String;
	}
	public void setCreate_String(String create_String) {
		this.create_String = create_String;
	}
	public String getDelete_String() {
		return delete_String;
	}
	public void setDelete_String(String delete_String) {
		this.delete_String = delete_String;
	}
	public String getEdit_String() {
		return edit_String;
	}
	public void setEdit_String(String edit_String) {
		this.edit_String = edit_String;
	}
	@Override
	public String toString() {
		return "BoardListMessage [board_idx=" + board_idx + ", title=" + title + ", content=" + content + ", exist="
				+ exist + ", create_String=" + create_String + ", delete_String=" + delete_String + ", edit_String=" + edit_String
				+ "]";
	}
	
	
}
