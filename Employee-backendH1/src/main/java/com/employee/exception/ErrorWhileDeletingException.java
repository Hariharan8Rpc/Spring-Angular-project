package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ErrorWhileDeletingException extends RuntimeException {
	private static final long serialVersionUID = 7082462969236019943L;

	public   ErrorWhileDeletingException(String message) {
		super (message);
	}
}
