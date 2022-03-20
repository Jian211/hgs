package com.bitcamp.hgs.place.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.hgs.place.domain.RegPlace;
import com.bitcamp.hgs.place.domain.RegPlaceInfo;

@Controller
@RequestMapping("/place")
public class UploadController {

//	@GetMapping("/upload")
//	public void uploadFile() {
//		
//	}
	
//	@PostMapping("/register")
//	public void uploadPost(RegPlaceInfo regPlaceInfo) {
//		System.out.println("regPlaceInfo ="+regPlaceInfo);
//
//		/*
//		String uploadFolder = "C:\\upload";
//		
//		for(MultipartFile multipartFile : uploadFile) {
//			
//			System.out.println(multipartFile.getOriginalFilename());
//			String uploadFileName = multipartFile.getOriginalFilename();
//			
//			File saveFile = new File(uploadFolder, uploadFileName);
//			
//			try {
//				multipartFile.transferTo(saveFile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}*/
//		
//		
//	}
}
