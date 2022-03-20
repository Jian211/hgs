package com.bitcamp.hgs.board.dao;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.hgs.board.domain.BoardListMessage;
import com.bitcamp.hgs.board.domain.PageView;
import com.bitcamp.hgs.board.domain.ReplyListItem;

public interface BoardDao {
	
	@Select("select count (*) from board")
	public int selectTotalCount(); //
	
	public List<BoardListMessage> selectList(int index, int count); // 게시물 리스트
	
	public PageView selectByIdx(int idx); //게시물 상세보기
	
	public List<ReplyListItem> selectReplyList(int id ); // 댓글리스트 불러오기
}
