//package com.schoolmanagement.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class StudentExceptionHandler {
//	
//	@ExceptionHandler
//	public String handelInvalidFieldException(InvalidFieldException exception) {
//		return exception.getMessage();
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<String> handelInvalidHeaderFieldException(InvalidHeaderFieldException exception){
//		return new ResponseEntity<>(exception.getMessage(), HttpStatus.PRECONDITION_FAILED);
//	}
//	
//}
