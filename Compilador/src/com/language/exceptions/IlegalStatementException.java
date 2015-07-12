package com.language.exceptions;

@SuppressWarnings("serial")
public class IlegalStatementException extends RuntimeException {

	public IlegalStatementException(String message, Throwable cause) {
		super(message, cause);
	}

	public IlegalStatementException(String message) {
		super(message);
	}

	public IlegalStatementException(Throwable cause) {
		super(cause);
	}

}
