package com.language.model.expression;

import com.language.exceptions.VariableNotExistException;
import com.language.stack.StackHandler;
import com.language.types.Types;

public class IdentifierExp extends Expression {

	String id;
	int line;
	
	public IdentifierExp(String id, int line){
		this.id = id;
		this.line = line;
	}
	
	public String getId() {
		return this.id;
	}

	@Override
	public Types eval() {
		StackHandler stackHandler = StackHandler.getInstance();
		
		Types variableValue = stackHandler.getStack().findInActualScope(id);
		Types globalVariable = stackHandler.getStack().findInGlobalScope(id);

		if (variableValue!=null){
			return variableValue;
		}
		else if (globalVariable!=null){
			return globalVariable;
		}
		else{
			throw new VariableNotExistException("Error at line " + this.line + ": variable \'" + id +"\' is not defined");

		}
		
	}

}
