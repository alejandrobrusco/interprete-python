package com.language.exceptions;

@SuppressWarnings("serial")
public class OutOfBoundException extends RuntimeException {

	public OutOfBoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OutOfBoundException(String message) {
		super(message);
	}

	public OutOfBoundException(Throwable cause) {
		super(cause);
	}

}
