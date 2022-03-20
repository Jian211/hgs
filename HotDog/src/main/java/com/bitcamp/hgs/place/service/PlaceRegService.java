package com.bitcamp.hgs.place.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.place.dao.PlaceDao;
import com.bitcamp.hgs.place.domain.PlaceFiles;
import com.bitcamp.hgs.place.domain.RegPlace;
import com.bitcamp.hgs.place.domain.RegPlaceInfo;

@Service
public class PlaceRegService {

	@Autowired
	private SqlSessionTemplate template;

	public void registPlace(RegPlaceInfo regPlaceInfo, HttpServletRequest request)
			throws IllegalStateException, IOException {


		RegPlace regPlace = regPlaceInfo.getPlace();

		template.getMapper(PlaceDao.class).registPlace(regPlace);

		System.out.println(regPlace.getPlaceIdx());

		// DB 관련 예외 발생 시 삭제 처리를 위한 File 객체 변수 선언
		File newFile = null;

		PlaceFiles placeFiles = null;
		// 파일이 있다면 -> 파일 저장
		if (!regPlaceInfo.getPhoto().isEmpty() && regPlaceInfo.getPhoto().getSize() > 0) {
			// 시스템의 경로
			String savePath = request.getSession().getServletContext().getRealPath("/uploadfile");
			String[] files = regPlaceInfo.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			regPlaceInfo.getPhoto().transferTo(newFile);
			
			int size = Long.valueOf(regPlaceInfo.getPhoto().getSize()).intValue();
			
			System.out.println(savePath);
			
			placeFiles = new PlaceFiles(regPlace.getPlaceIdx(), newFileName, size);
		}
		
		
		
		
		template.getMapper(PlaceDao.class).insertFile(placeFiles);
		
		System.out.println("성공");

	}
}
