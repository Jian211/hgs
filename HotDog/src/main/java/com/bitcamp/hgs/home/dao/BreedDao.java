package com.bitcamp.hgs.home.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bitcamp.hgs.home.domain.Breed;

@Mapper
public interface BreedDao {

	@Select("select * from hgs.breeds")
	public List<Breed> selectDogTypeList();
	
	@Select("select count(*) from hgs.breeds where dog_type like concat(#{dogType})")
	public int selectDogType(String dogType);
	
}
