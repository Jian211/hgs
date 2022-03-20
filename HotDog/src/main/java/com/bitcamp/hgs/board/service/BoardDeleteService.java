package com.bitcamp.hgs.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;

@Service
public class BoardDeleteService {

	private BoardDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public void deleteBoard(int boardIdx) {
		
		dao = template.getMapper(BoardDao.class);
		
		dao.deleteBoard(boardIdx);
		
	}

}
