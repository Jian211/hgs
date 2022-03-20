package com.bitcamp.hgs.board.domain;

public class ReplyRequest {
	private int member_idx;
	private int board_idx;
	private String message;
	
	public ReplyRequest() {}

	public ReplyRequest(int member_idx, int board_idx, String message) {
		super();
		this.member_idx = member_idx;
		this.board_idx = board_idx;
		this.message = message;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReplyRequest [member_idx=" + member_idx + ", board_idx=" + board_idx + ", message=" + message + "]";
	}
	
	

}
