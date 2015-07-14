package com.language.exceptions;

@SuppressWarnings("serial")
public class IlegalArgumentException extends RuntimeException {

	public IlegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public IlegalArgumentException(String message) {
		super(message);
	}

	public IlegalArgumentException(Throwable cause) {
		super(cause);
	}

}
