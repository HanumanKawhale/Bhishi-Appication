package com.bhishiapplication.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
		 
		String massage = exception.getMessage();
		return new ResponseEntity<>(massage,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
		
		Map<String,String> map = new HashMap<>();
		
		exception.getBindingResult().getAllErrors().forEach((e)->{
			String massage = e.getDefaultMessage();
			String field = ((FieldError) e).getField();
			map.put(field,massage);
		});
		
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
}
