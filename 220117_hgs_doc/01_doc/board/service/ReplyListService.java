package com.bitcamp.hgs.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;
import com.bitcamp.hgs.domain.ReplyListItem;
@Service
public class ReplyListService {
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<ReplyListItem> getList(int idx){
		return template.getMapper(BoardDao.class).selectReplyList(idx);
	}
}
