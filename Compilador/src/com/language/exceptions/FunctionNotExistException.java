package com.language.exceptions;

@SuppressWarnings("serial")
public class FunctionNotExistException extends RuntimeException {

	public FunctionNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionNotExistException(String message) {
		super(message);
	}

	public FunctionNotExistException(Throwable cause) {
		super(cause);
	}

}
