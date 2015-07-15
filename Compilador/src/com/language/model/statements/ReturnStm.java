package com.language.model.statements;

import com.language.exceptions.IlegalStatementException;
import com.language.model.expression.Expression;
import com.language.stack.StackHandler;
import com.language.types.ReturnType;
import com.language.types.Types;
import com.language.types.VoidType;

public class ReturnStm extends Statement {

	Expression expr;
	int line;

	public ReturnStm(Expression expr, int line) {
		this.expr = expr;
		this.line = line;
	}
	
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		Boolean returnScope = handler.getScopeReturn();
		if (returnScope){
			if (expr!=null){
				Types evalType = expr.eval();
				Types returnType = new ReturnType(evalType);
				return returnType;
			}
			else{
				return new VoidType();
			}
		}
		else{
			throw new IlegalStatementException("Error at line "+ this.line +": \'return\' sentence not in Function Definition");
		}
		
	}
	
}
