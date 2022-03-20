package com.bitcamp.hgs.home.dao;

import java.util.List;

import com.bitcamp.hgs.home.domain.HomeBoard;
import com.bitcamp.hgs.member.domain.Hashtag;

public interface HomeBoardDao {

	List<HomeBoard> selectHomeBoardList(List<Hashtag> tags);

	List<HomeBoard> selectSearchBoardList(String q);


}
