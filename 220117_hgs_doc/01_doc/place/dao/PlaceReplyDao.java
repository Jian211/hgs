package com.bitcamp.hgs.place.dao;

import com.bitcamp.hgs.place.domain.PlaceReplys;

public interface PlaceReplyDao {

	void insertReply(PlaceReplys replys);
	
	int deleteByIdx(int idx);
}
