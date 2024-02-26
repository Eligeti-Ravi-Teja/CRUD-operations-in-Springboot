package com.jsp.projectStudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.projectStudent.util.ResponseStructure;

@RestControllerAdvice
public class PasswordIncorrectHandler {
	@ExceptionHandler(IncorrectPassword.class)
	public ResponseEntity<ResponseStructure<String>> passwordHandle(IncorrectPassword e){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(e.getMsg());
		rs.setMessage("please try again!!");
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.NOT_FOUND);
	}
}
