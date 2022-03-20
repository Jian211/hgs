package com.bitcamp.hgs.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;
import com.bitcamp.hgs.board.domain.PageView;
@Service
public class BoardPageViewService {
	
	private BoardDao dao;
	
	@Autowired 
	private SqlSessionTemplate template;
	
	public PageView getPageView(int idx) {
		
		return template.getMapper(BoardDao.class).selectByIdx(idx);
	}
}
