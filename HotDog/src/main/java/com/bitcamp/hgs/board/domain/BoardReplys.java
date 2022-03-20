package com.bitcamp.hgs.board.domain;

import java.sql.Timestamp;

public class BoardReplys {
	
	private int boardReplyIdx;	
	private int boardIdx;		
	private int memberIdx = 1;		
	private String content;		
	private Timestamp createDate;	
	private Timestamp editDate;	
	
	public BoardReplys() {}

	public BoardReplys(int boardReplyIdx, int boardIdx, int memberIdx, String content, Timestamp createDate,
			Timestamp editDate) {
		this.boardReplyIdx = boardReplyIdx;
		this.boardIdx = boardIdx;
		this.memberIdx = memberIdx;
		this.content = content;
		this.createDate = createDate;
		this.editDate = editDate;
	}

	public int getBoardReplyIdx() {
		return boardReplyIdx;
	}

	public void setBoardReplyIdx(int boardReplyIdx) {
		this.boardReplyIdx = boardReplyIdx;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getEditDate() {
		return editDate;
	}

	public void setEditDate(Timestamp editDate) {
		this.editDate = editDate;
	}

	@Override
	public String toString() {
		return "BoardReplys [boardReplyIdx=" + boardReplyIdx + ", boardIdx=" + boardIdx + ", memberIdx=" + memberIdx
				+ ", content=" + content + ", createDate=" + createDate + ", editDate=" + editDate + "]";
	}
	
	
	
	

	
}
