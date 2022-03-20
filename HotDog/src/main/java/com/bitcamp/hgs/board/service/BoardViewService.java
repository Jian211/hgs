package com.bitcamp.hgs.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;
import com.bitcamp.hgs.board.domain.Boards;

@Service
public class BoardViewService {

	private BoardDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public Boards getPageView(int boardIdx) {

		return template.getMapper(BoardDao.class).selectByIdx(boardIdx);
	}
	

}
