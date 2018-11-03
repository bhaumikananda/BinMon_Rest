package org.binmon.demo.exception;

import org.binmon.demo.jpa.domain.Dept;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@RequestMapping(produces = "application/json")
	@ExceptionHandler(value = {Throwable.class})
	protected ResponseEntity<Dept> handleException(Throwable ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Exception", ex.getMessage());
		return new ResponseEntity<Dept>(new Dept(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}	