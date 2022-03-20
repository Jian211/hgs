package com.bitcamp.hgs.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardReplyDao;
import com.bitcamp.hgs.board.domain.BoardReplys;

@Service
public class BoardReplyService {

	private BoardReplyDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 후기 목록보기
	public List<BoardReplys> getList(int BoardIdx) {
		
		
		
		return template.getMapper(BoardReplyDao.class).getList(BoardIdx);
	}

	// 댓글 등록
	public void registReply(BoardReplys reply) {

		dao = template.getMapper(BoardReplyDao.class);

		dao.registReply(reply);

	}

	// 댓글 삭제
	public int deleteReply(int boardReplyIdx) {

		return template.getMapper(BoardReplyDao.class).deleteReply(boardReplyIdx);
	}

	// 후기 수정
	//public int updateReply(PlaceReplys reply) {

		//dao = template.getMapper(PlaceReplyDao.class);

		//return dao.updateReply(reply);
	//}
}
