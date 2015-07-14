package com.language.exceptions;

@SuppressWarnings("serial")
public class VariableNotExistException extends RuntimeException {

    public VariableNotExistException(String message, Throwable cause) {
    	super(message, cause);
    }
	
    public VariableNotExistException(String message) {
    	super(message);
    }
    
    public VariableNotExistException(Throwable cause) {
    	super(cause);
    }

}
