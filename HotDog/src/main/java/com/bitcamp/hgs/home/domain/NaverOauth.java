package com.bitcamp.hgs.home.domain;

public class NaverOauth {
	
    private final String CLIENT_ID = "5aNOGrdJbdtyJSOIZFn3";
    private final String CLIENT_SERCRET = "WB_9dwfx_G";
    private final String TOKEN_URL = "https://nid.naver.com/oauth2.0/token";
    private final String API_URL = "https://openapi.naver.com/v1/nid/me";
    private final String REDIRECT_URL = "http://localhost:8080/hgs/oauth/naver";
    private final String GRANT_TYPE = "authorization_code";
    private String accessToken;
	private String refreshToken;
	
	public NaverOauth() {	}
	
	public NaverOauth(String accessToken, String refreshToken) {
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

	public String getCLIENT_SERCRET() {
		return CLIENT_SERCRET;
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
		return "NaverOauth [CLIENT_ID=" + CLIENT_ID + ", CLIENT_SERCRET=" + CLIENT_SERCRET + ", TOKEN_URL=" + TOKEN_URL
				+ ", API_URL=" + API_URL + ", REDIRECT_URL=" + REDIRECT_URL + ", GRANT_TYPE=" + GRANT_TYPE
				+ ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}

	
	
	
	

}
