package com.bitcamp.hgs.board.service;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;
import com.bitcamp.hgs.board.domain.BoardListMessage;
import com.bitcamp.hgs.board.domain.BoardListView;

@Service
public class BoardListService {

		private BoardDao dao;
		
		@Autowired
		private SqlSessionTemplate template;
		
		// 페이지 당 노출할 메세지의 수
		private final int COUNT_PER_PAGE = 6;
		// 페이징 번호 노출 개수
		private final int COUNT_PER_PAGING_NUM = 5;
		
		public BoardListView getPage(int currentPage) {
			
			dao = template.getMapper(BoardDao.class);
			
			int totalCount = dao.selectTotalCount();
			int index = (currentPage - 1) * COUNT_PER_PAGE;
			
			//화면에 노출할 메세지
			List<BoardListMessage> list = dao.selectList(index, COUNT_PER_PAGE);
			
			return new BoardListView(currentPage, COUNT_PER_PAGING_NUM, list, totalCount);
		
		}
}
