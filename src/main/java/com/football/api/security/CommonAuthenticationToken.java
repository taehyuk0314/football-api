package com.football.api.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import lombok.Getter;

public class CommonAuthenticationToken extends AbstractAuthenticationToken  {
    	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String credential;
	
	@Getter
	String fcmUserToken;
	@Getter
	String userAgent;
	

	public CommonAuthenticationToken(String id, String credential, String fcmUserToken, String userAgent) {
		super(null);
		this.id = id;
		this.credential = credential;
		this.fcmUserToken = fcmUserToken;
		this.userAgent = userAgent;
		
	}
	

	@Override
	public Object getCredentials() {
		return this.credential;
	}

	@Override
	public Object getPrincipal() {
		return this.id;
	}
    
}
