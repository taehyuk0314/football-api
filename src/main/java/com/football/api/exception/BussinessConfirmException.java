package com.football.api.exception;

import lombok.Getter;

@Getter
public class BussinessConfirmException extends RuntimeException {
    
    String messageCode;
	String[] args;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7851203549081854683L;

	
	public BussinessConfirmException() {
		super();
	}
	
	public BussinessConfirmException(String messageCode) {
		super();
		this.messageCode = messageCode;
	}

	public BussinessConfirmException(String messageCode, String... args) {
		super();
		this.messageCode = messageCode;
		this.args = args;
	}
}
