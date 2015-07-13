package com.language.exceptions;

@SuppressWarnings("serial")
public class TypeErrorException extends RuntimeException {

	public TypeErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public TypeErrorException(String message) {
		super(message);
	}

	public TypeErrorException(Throwable cause) {
		super(cause);
	}

}
