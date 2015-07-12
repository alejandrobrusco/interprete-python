package com.language.model.statements;

import com.language.exceptions.IlegalStatementException;
import com.language.stack.ControlVariable;
import com.language.stack.StackHandler;
import com.language.types.BreakType;
import com.language.types.Types;

public class BreakStm extends Statement {


	public BreakStm() {
	}
	
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		ControlVariable controlVariable = handler.getActualScopeControlVariable();
		
		if (controlVariable.isBreakContext()){
			return new BreakType();
		}
		else{
			throw new IlegalStatementException("BREAK Sentence not in Iteration Definition\n");
		}
	}
	
}
