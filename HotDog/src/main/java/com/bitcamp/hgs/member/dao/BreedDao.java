package com.bitcamp.hgs.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BreedDao {

	@Select("select dog_type from hgs.breeds where dog_type like concat('%',#{dogType},'%')")
	public List<String> selectDogTypeList(String dogType);
	
	@Select("select count(*) from hgs.breeds where dog_type like concat(#{dogType})")
	public int selectDogType(String dogType);
	
}
