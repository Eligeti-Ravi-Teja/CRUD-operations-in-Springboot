package com.jsp.projectStudent.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IncorrectPassword extends RuntimeException{
	private String msg="Incorrect password";
}
