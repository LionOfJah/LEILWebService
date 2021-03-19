package com.icicibank.apimgmt.exception.handler;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.icicibank.apimgmt.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	ErrorResponse errorResponse;
	
	@ExceptionHandler(value = {InvalidKeyException.class,SignatureException.class,NoSuchAlgorithmException.class,SignatureException.class,UnsupportedEncodingException.class})
	public ResponseEntity<ErrorResponse> handleException(RuntimeException ex,HttpStatus status){
		
		errorResponse.setStatusCode(status.CONFLICT);
		errorResponse.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.ok().body(errorResponse);
	}
	
	
}
