package com.football.api.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.football.api.config.vo.ExceptionMessageVO;
import com.football.api.exception.BussinessConfirmException;
import com.football.api.exception.BussinessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@org.springframework.web.bind.annotation.ExceptionHandler(BussinessConfirmException.class)
	protected ResponseEntity<Object> bussinessConfirmException(BussinessConfirmException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ExceptionMessageVO(ex.getMessageCode(), ex.getClass().getSimpleName(), ex.getArgs()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}    
	@org.springframework.web.bind.annotation.ExceptionHandler(BussinessException.class)
	protected ResponseEntity<Object> bussinessException(BussinessException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ExceptionMessageVO(ex.getMessageCode(), ex.getClass().getSimpleName(), ex.getArgs()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}    
	@org.springframework.web.bind.annotation.ExceptionHandler(com.football.api.security.CountedBadCredentialsException.class)
	protected ResponseEntity<Object> CountedBadCredentialsException(com.football.api.security.CountedBadCredentialsException ex, WebRequest request) {
		return handleExceptionInternal(ex, new ExceptionMessageVO(ex.getMessage(), ex.getClass().getSimpleName(), new String[] {String.valueOf(ex.getCount())}), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}	
}
