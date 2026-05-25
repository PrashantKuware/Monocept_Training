package com.monocept.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleStudentNotFoundException (StudentNotFoundException ex)
	{
		Map<String, Object> errorBody = new HashMap();
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Status", HttpStatus.NOT_FOUND.value());
		errorBody.put("Error", "Not Found");
		errorBody.put("Message", ex.getMessage());
		
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, Object>> handleTypemismatchException (MethodArgumentTypeMismatchException ex)
	{
		Map<String, Object> errorBody = new HashMap();
		
		errorBody.put("Timestamp", LocalDateTime.now());
		errorBody.put("Status", HttpStatus.BAD_REQUEST.value());
		errorBody.put("Error", "Bad Request");
		errorBody.put("Message", "Invalid Id, Id must be a number");
		
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
		
	}
}
