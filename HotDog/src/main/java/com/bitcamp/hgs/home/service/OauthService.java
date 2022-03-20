package com.bitcamp.hgs.home.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.domain.KakaoOauth;
import com.bitcamp.hgs.home.domain.NaverOauth;
import com.bitcamp.hgs.home.exception.SnsTypeException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class OauthService {

	// Autowirde 왜 안되ㅣ뉭
	private KakaoOauth kakaoOauth = new KakaoOauth();
	private NaverOauth naverOauth = new NaverOauth();
	
	// 현재 오류 있음
	public String getAccessToken(String snsType,String code) {
		String accessToken = "";
		try {
			if(snsType.equals("kakao")) {
				URL url = new URL(kakaoOauth.getTOKEN_URL());
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				StringBuilder sb = new StringBuilder();
				sb.append("grant_type="+ kakaoOauth.getGRANT_TYPE());
				sb.append("&client_id="+kakaoOauth.getCLIENT_ID());
				sb.append("&redirect_uri="+kakaoOauth.getREDIRECT_URL());
				sb.append("&code="+code);
				
				System.out.println("sb : " +sb.toString());
				bw.write(sb.toString());
				bw.flush();
				
				int responseCode = conn.getResponseCode();
				System.out.println("response code = "+ responseCode);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = "";
				String result = "";
				while((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : "+ result);
				
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				kakaoOauth.setAccessToken( accessToken = element.getAsJsonObject().get("access_token").getAsString());
				kakaoOauth.setRefreshToken(element.getAsJsonObject().get("refresh_token").getAsString());
	
				br.close();
				bw.close();
				
			}
		
			else if(snsType.equals("naver")) {
				URL url = new URL(naverOauth.getTOKEN_URL());
				HttpURLConnection conn = (HttpURLConnection)url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				StringBuilder sb = new StringBuilder();
				sb.append("grant_type="+ naverOauth.getGRANT_TYPE());
				sb.append("&client_id="+ naverOauth.getCLIENT_ID());
				sb.append("&client_secret="+ naverOauth.getCLIENT_SERCRET());
				sb.append("&code="+code);
				
				bw.write(sb.toString());
				bw.flush();
				
				int responseCode = conn.getResponseCode();
				System.out.println("response code = "+ responseCode);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = "";
				String result = "";
				while((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : "+ result);
				
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				naverOauth.setAccessToken( accessToken = element.getAsJsonObject().get("access_token").getAsString());
				naverOauth.setRefreshToken(element.getAsJsonObject().get("refresh_token").getAsString());
				
				br.close();
				bw.close();
			}
			else {
				throw new SnsTypeException("다른 SNS타입을 입력하셨습니다.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}


	public String getEmail(String snsType, String accessToken) {
		String email = "";
		try {
			if(snsType.equals("kakao")) {
				URL url = new URL(kakaoOauth.getAPI_URL());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Authorization", "Bearer "+ accessToken);
				
				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = "";
				String result = "";
				
				while((line = br.readLine()) != null) {
					result += line;
				}
				
				System.out.println("response body : " + result);
				
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
				
				email =  kakaoAccount.getAsJsonObject().get("email").getAsString();
			} 
			
			else if(snsType.equals("naver")){
				URL url = new URL(naverOauth.getAPI_URL());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Authorization", "Bearer "+ accessToken);
				
				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String line = "";
				String result = "";
				
				while((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : " + result);
				
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				JsonObject naverAccount = element.getAsJsonObject().get("response").getAsJsonObject();
				
				email =  naverAccount.getAsJsonObject().get("email").getAsString();
				
			}
			
			else {
				throw new SnsTypeException("다른 SNS타입을 입력하셨습니다.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return email;
	}
	
}
