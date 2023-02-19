package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN)
public class NotAbleToSaveException extends RuntimeException {
	private static final long serialVersionUID = 2L;
	
	public NotAbleToSaveException(String message) {
		  super (message);
	  }
}

