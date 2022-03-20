package com.bitcamp.hgs.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
	JavaMailSender sender;
	
	public int send (String email, String memberName) {
		
		int result = 1;
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			// 메일 제목
			String subject = "[안내]" + memberName + "야 너도 핫하구나!!! 와줘서 고마워!!";
			message.setSubject(subject,"utf-8");


			// 메일 내용
			String html = "<h2> 회원가입을 축하드립니다. </h2>";
			html += "<a href='http://localhost:8080/hgs'>핫핫핫! 개들의 모임</a><br>";
			
			message.setText(html, "utf-8", "html");
			
			// from   !구글은  setform이 적용되지 않음
			message.setFrom(new InternetAddress("hotdog@naver.com"));
			
			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, memberName+"님","utf-8"));
			
			sender.send(message);
			
		} catch (AddressException e) {
			System.out.println("메일발송 실패 : 이메일 형식에 맞지 않음!!!");
		} catch (SendFailedException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MailSendException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MessagingException e) {
			result = 0;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			result = 0;
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}