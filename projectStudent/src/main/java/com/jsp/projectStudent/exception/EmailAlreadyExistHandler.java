package com.jsp.projectStudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.projectStudent.util.ResponseStructure;

@RestControllerAdvice
public class EmailAlreadyExistHandler {
	@ExceptionHandler(EmailAlreadyExist.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailNotFound(EmailAlreadyExist e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(e.getMessage());
		rs.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("Try to login");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_ACCEPTABLE);
		}
}
