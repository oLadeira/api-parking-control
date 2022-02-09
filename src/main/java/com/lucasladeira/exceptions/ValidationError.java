package com.lucasladeira.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends ErrorBody{
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String message, Long timestamp) {
		super(status, message, timestamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String field, String message) {
		errors.add(new FieldMessage(field, message));
	}
}
