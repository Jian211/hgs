package com.bitcamp.hgs.home.domain;


public class KakaoOauth {
	
    private final String CLIENT_ID = "43759419ecbf05fbee7b1064e2ea3094";
    private final String TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private final String API_URL = "https://kapi.kakao.com/v2/user/me";
    private final String REDIRECT_URL = "http://localhost:8080/hgs/member/oauth/kakao";
    private final String GRANT_TYPE = "authorization_code";
    private String accessToken;
	private String refreshToken;
	
	
	public KakaoOauth() {	}

	public KakaoOauth(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getCLIENT_ID() {
		return CLIENT_ID;
	}
	public String getTOKEN_URL() {
		return TOKEN_URL;
	}
	public String getAPI_URL() {
		return API_URL;
	}
	public String getREDIRECT_URL() {
		return REDIRECT_URL;
	}
	public String getGRANT_TYPE() {
		return GRANT_TYPE;
	}

	@Override
	public String toString() {
		return "KakaoOauth [CLIENT_ID=" + CLIENT_ID + ", TOKEN_URL=" + TOKEN_URL + ", API_URL=" + API_URL
				+ ", REDIRECT_URL=" + REDIRECT_URL + ", GRANT_TYPE=" + GRANT_TYPE + ", accessToken=" + accessToken
				+ ", refreshToken=" + refreshToken + "]";
	}

	
	
	
	

}
