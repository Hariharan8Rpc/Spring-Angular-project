package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.CONFLICT)
public class AlreadyExistException extends RuntimeException{
	private static final long serialVersionUID = 2L;
	
	public AlreadyExistException(String message) {
		  super (message);
	  }
}
