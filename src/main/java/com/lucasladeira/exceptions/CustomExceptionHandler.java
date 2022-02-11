package com.lucasladeira.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucasladeira.services.exceptions.ConflictException;
import com.lucasladeira.services.exceptions.DataIntegrityException;
import com.lucasladeira.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorBody> objectNotFound(com.lucasladeira.services.exceptions.ObjectNotFoundException e, HttpServletRequest request){
		ErrorBody err = new ErrorBody(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ErrorBody> conflictError(ConflictException e, HttpServletRequest request){
		ErrorBody err = new ErrorBody(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorBody> argumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(err.getStatus()).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<ErrorBody> dataIntegrityViolationException(DataIntegrityException e, HttpServletRequest request){
		ErrorBody err = new ErrorBody(HttpStatus.CONFLICT.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(err.getStatus()).body(err);
	}
}
