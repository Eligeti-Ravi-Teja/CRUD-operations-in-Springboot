package com.jsp.projectStudent.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDoesNotExist extends RuntimeException{
	private String message="Email doesnot exist try to login";

}
