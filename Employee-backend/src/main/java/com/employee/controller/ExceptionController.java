package com.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.AlreadyExistException;
import com.employee.exception.ErrorWhileDeletingException;
import com.employee.exception.NotAbleToSaveException;
import com.employee.exception.ResourceNotFoundException;


@RestControllerAdvice
public class ExceptionController {
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(AlreadyExistException.class)
	public String AlreadyExist(Exception ex) {
		return ex.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	@ExceptionHandler(NotAbleToSaveException.class)
	public String NotAbleToSave(Exception ex) {
		return ex.getMessage();
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public String ResourceNotFound(Exception ex) {
		return ex.getMessage();
	}
	
	
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(ErrorWhileDeletingException.class)
	public String ErrorWhileDeleting(Exception ex) {
		return ex.getMessage();
	}
}

