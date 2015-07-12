package com.language.model.statements;

import com.language.exceptions.IlegalStatementException;
import com.language.model.expression.Expression;
import com.language.stack.StackHandler;
import com.language.types.ReturnType;
import com.language.types.Types;

public class ReturnStm extends Statement {

	Expression expr;

	public ReturnStm(Expression expr) {
		this.expr = expr;
	}
	
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		Boolean returnScope = handler.getScopeReturn();
		if (returnScope){
			Types evalType = expr.eval();
			Types returnType = new ReturnType(evalType);
			return returnType;
		}
		else{
			throw new IlegalStatementException("RETURN Sentence not in Function Definition\n");
		}
		
	}
	
}
