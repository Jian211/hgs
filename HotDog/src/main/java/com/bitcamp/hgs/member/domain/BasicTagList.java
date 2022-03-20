package com.bitcamp.hgs.member.domain;

import java.util.ArrayList;
import java.util.List;

// 회원가입 및 회원수정에 들어가는 해시태그 리스트 목록이다.
public class BasicTagList {
	private Hashtag tag1  = new Hashtag(28,"대형견");
	private Hashtag tag2  = new Hashtag(29,"중형견");
	private Hashtag tag3  = new Hashtag(30,"소형견");
	private Hashtag tag4  = new Hashtag(8,"산책");
	private Hashtag tag5  = new Hashtag(3,"강아지");
	private Hashtag tag6  = new Hashtag(17,"장난감");
	private Hashtag tag7  = new Hashtag(9,"사료");
	private Hashtag tag8  = new Hashtag(1,"동물병원");
	private Hashtag tag9  = new Hashtag(5,"애견카페");
	private Hashtag tag10 = new Hashtag(2,"공원");
	
	public BasicTagList(){}

	public List<Hashtag> getBTL(){
		List<Hashtag> list = new ArrayList<Hashtag>();
		list.add(tag1);
		list.add(tag2);
		list.add(tag3);
		list.add(tag4);
		list.add(tag5);
		list.add(tag6);
		list.add(tag7);
		list.add(tag8);
		list.add(tag9);
		list.add(tag10);
		return list;
	}

	@Override
	public String toString() {
		return "BasicTagList [tag1=" + tag1 + ", tag2=" + tag2 + ", tag3=" + tag3 + ", tag4=" + tag4 + ", tag5=" + tag5
				+ ", tag6=" + tag6 + ", tag7=" + tag7 + ", tag8=" + tag8 + ", tag9=" + tag9 + ", tag10=" + tag10 + "]";
	}
	
	
}
