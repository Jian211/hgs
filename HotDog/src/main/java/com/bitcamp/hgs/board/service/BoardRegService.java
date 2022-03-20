package com.bitcamp.hgs.board.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.board.dao.BoardDao;
import com.bitcamp.hgs.board.domain.BoardFiles;
import com.bitcamp.hgs.board.domain.RegBoard;
import com.bitcamp.hgs.board.domain.RegBoardInfo;
import com.bitcamp.hgs.place.domain.PlaceFiles;

@Service
public class BoardRegService {

	
	@Autowired
	private SqlSessionTemplate template;


	public void registBoard(RegBoardInfo regBoardInfo, HttpServletRequest request)
			throws IllegalStateException, IOException {

		RegBoard regBoard = regBoardInfo.getBoard();
		
		// return 값 멤버 idx
		template.getMapper(BoardDao.class).registBoard(regBoard);

		

		// DB 관련 예외 발생 시 삭제 처리를 위한 File 객체 변수 선언
		File newFile = null;

		BoardFiles boardFiles = null;
		// 파일이 있다면 -> 파일 저장
		if (!regBoardInfo.getPhoto().isEmpty() && regBoardInfo.getPhoto().getSize() > 0) {
			// 시스템의 경로
			String savePath = request.getSession().getServletContext().getRealPath("/uploadfile");
			String[] files = regBoardInfo.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			regBoardInfo.getPhoto().transferTo(newFile);
			
			int size = Long.valueOf(regBoardInfo.getPhoto().getSize()).intValue();
			
			System.out.println(savePath);
			
			boardFiles = new BoardFiles(regBoard.getBoardIdx(), newFileName, size);
		}
		
		
		template.getMapper(BoardDao.class).insertFile(boardFiles);
		
		// 해시태그 테이블에 해시태그랑 아디값 
			// 만약 해시태그가 중복이 되면, 그 값은 저장 X
			// 중복이 아니면 해시태그를 저장하고 
			
			// 저장한 해시태그의 idx값을 보드 해시태그 테이블에 member idx 값과 함께 저장 해야한다.
		
		System.out.println("성공");
		

		

	}
}
