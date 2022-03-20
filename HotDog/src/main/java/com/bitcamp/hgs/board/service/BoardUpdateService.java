package com.bitcamp.hgs.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;
import com.bitcamp.hgs.board.domain.Boards;

@Service
public class BoardUpdateService {

	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void updateBoard(Boards board) {
		
		dao = template.getMapper(BoardDao.class);
		
		dao.updateBoard(board);
	}
}
