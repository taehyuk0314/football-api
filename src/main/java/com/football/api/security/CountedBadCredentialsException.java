package com.football.api.security;

import org.springframework.security.authentication.BadCredentialsException;

import lombok.Getter;

@Getter
public class CountedBadCredentialsException extends BadCredentialsException {
	private static final long serialVersionUID = 1L;
	
	int count;
	
	public CountedBadCredentialsException(String msg, int count) {
		super(msg);
		this.count = count;
	}
}
