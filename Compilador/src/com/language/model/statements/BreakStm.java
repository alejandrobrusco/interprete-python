package com.language.model.statements;

import com.language.exceptions.IlegalStatementException;
import com.language.stack.ControlVariable;
import com.language.stack.StackHandler;
import com.language.types.BreakType;
import com.language.types.Types;

public class BreakStm extends Statement {

	int line;

	public BreakStm(int line) {
		this.line = line;
	}
	
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		ControlVariable controlVariable = handler.getActualScopeControlVariable();
		
		if (controlVariable.isBreakContext()){
			return new BreakType();
		}
		else{
			throw new IlegalStatementException("Error at line " + this.line + ": \'break\' Sentence not in Iteration Definition\n");
		}
	}
	
}
