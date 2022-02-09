package com.lucasladeira.services.exceptions;

public class ArgumentNotValidException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ArgumentNotValidException(String msg) {
		super(msg);
	}
}
