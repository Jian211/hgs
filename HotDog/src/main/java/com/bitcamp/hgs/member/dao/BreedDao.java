package com.bitcamp.hgs.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bitcamp.hgs.member.domain.Breed;

public interface BreedDao {

	@Select("select * from hgs.breeds")
	public List<Breed> selectDogTypeList();
	
	@Select("select count(*) from hgs.breeds where dog_type like concat(#{dogType})")
	public int selectDogType(String dogType);
	
}
