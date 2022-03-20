package com.bitcamp.hgs.board.dao;

import java.util.List;

import com.bitcamp.hgs.board.domain.BoardReplys;

public interface BoardReplyDao {

	// 댓글 전체 목록(일반 게시물 idx기준)
	public List<BoardReplys> getList(int boardIdx);
	
	// 댓글 입력
	public void registReply(BoardReplys reply);
	
	// 댓글삭제
	public int deleteReply(int idx);
	
	// 댓글 수정
	public int updateReply(BoardReplys reply);
	
}
