package com.jsp.projectStudent.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String message;
	private T data;
	private int status;
}
