package com.ogs.poc.exception;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CoreException.class)
	public ResponseEntity<ResponseStatus> handleAccessDeniedException(CoreException ex) {
		ResponseStatus rs = new ResponseStatus();
		rs.setMessage(ex.getMessage());
		return new ResponseEntity<ResponseStatus>(rs ,OK);

	}
}