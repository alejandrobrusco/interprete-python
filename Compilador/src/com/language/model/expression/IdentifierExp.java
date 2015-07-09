package com.language.model.expression;

import com.language.stack.StackHandler;
import com.language.types.Types;

public class IdentifierExp extends Expression {

	String id;
	
	public IdentifierExp(String id){
		this.id = id;
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
			// EXCEPTION
			return null;
		}
		
	}

}
