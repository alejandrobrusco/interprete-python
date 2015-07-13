package com.language.exceptions;

@SuppressWarnings("serial")
public class OperationNotExistException extends RuntimeException {

    public OperationNotExistException(String message, Throwable cause) {
    	super(message, cause);
    }
	
    public OperationNotExistException(String message) {
    	super(message);
    }
    
    public OperationNotExistException(Throwable cause) {
    	super(cause);
    }

}
