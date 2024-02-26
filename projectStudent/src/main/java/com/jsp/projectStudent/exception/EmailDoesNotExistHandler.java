package com.jsp.projectStudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.projectStudent.util.ResponseStructure;

@RestControllerAdvice
public class EmailDoesNotExistHandler {
	@ExceptionHandler(EmailDoesNotExist.class)
	public ResponseEntity<ResponseStructure<String>> NewEmailHandler(EmailDoesNotExist e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(e.getMessage());
		rs.setMessage("Please try with another email or register");
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}

}
