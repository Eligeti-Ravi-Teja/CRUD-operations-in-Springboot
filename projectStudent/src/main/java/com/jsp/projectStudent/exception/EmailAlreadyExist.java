package com.jsp.projectStudent.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailAlreadyExist extends RuntimeException{
	private String message="eamil alredy registered! Try to login";

}
