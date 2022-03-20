package com.bitcamp.hgs.board.domain;

public class ReplyListItem {

	private int board_reply_idx;
	private String content;
	private String create_date;
	private String edit_date;
	private int board_idx;
	private int member_idx;
	
	public ReplyListItem() {}

	public ReplyListItem(int board_reply_idx, String content, String create_date, String edit_date, int board_idx,
			int member_idx) {
		super();
		this.board_reply_idx = board_reply_idx;
		this.content = content;
		this.create_date = create_date;
		this.edit_date = edit_date;
		this.board_idx = board_idx;
		this.member_idx = member_idx;
	}

	public int getBoard_reply_idx() {
		return board_reply_idx;
	}

	public void setBoard_reply_idx(int board_reply_idx) {
		this.board_reply_idx = board_reply_idx;
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

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	@Override
	public String toString() {
		return "ReplyListItem [board_reply_idx=" + board_reply_idx + ", content=" + content + ", create_date="
				+ create_date + ", edit_date=" + edit_date + ", board_idx=" + board_idx + ", member_idx=" + member_idx
				+ "]";
	}
	
}
