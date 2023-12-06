package com.football.api.config.vo;

import lombok.Data;

@Data
public class ExceptionMessageVO {
    String messageCode;
	String exceptionName;
	String[] args;
	
	public ExceptionMessageVO(String messageCode, String exceptionName) {
		this.messageCode = messageCode;
		this.exceptionName = exceptionName; 
	}
	public ExceptionMessageVO(String messageCode, String exceptionName, String[] args) {
		this.messageCode = messageCode;
		this.exceptionName = exceptionName;
		this.args = args;
	}	
}
