package com.language.model.statements;

import com.language.exceptions.IlegalStatementException;
import com.language.model.expression.Expression;
import com.language.stack.ControlVariable;
import com.language.stack.StackHandler;
import com.language.types.ContinueType;
import com.language.types.ReturnType;
import com.language.types.Types;

public class ContinueStm extends Statement {
	
	int line;

	public ContinueStm(int line) {
		this.line = line;
	}
	
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		ControlVariable controlVariable = handler.getActualScopeControlVariable();
		
		if (controlVariable.isContinueContext()){
			return new ContinueType();
		}
		else{
			throw new IlegalStatementException("Error at line " + this.line + ": \'continue\' Sentence not in Iteration Definition\n");
		}
		
	}
	
}
