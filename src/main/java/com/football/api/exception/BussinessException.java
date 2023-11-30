package com.football.api.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BussinessException extends Exception {
	String messageCode;
	String[] args;
        
    public BussinessException() {
		super();
	}

	public BussinessException(String messageCode) {
		super();
		this.messageCode = messageCode;
	}

	public BussinessException(String messageCode, String... args) {
		super();
		this.messageCode = messageCode;
		this.args = args;
	}
}
