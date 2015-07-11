package com.language.model.statements;

import com.language.model.expression.Expression;
import com.language.model.expression.IdentifierExp;
import com.language.model.statements.Statement;
import com.language.stack.StackHandler;
import com.language.types.Types;
import com.language.types.VoidType;

public class AssignStm extends Statement {

	IdentifierExp id;
	Expression expression;
	
	public AssignStm(IdentifierExp id, Expression expression){
		this.id = id;
		this.expression = expression;
	}
	
	public Types eval(){
		
		StackHandler handler = StackHandler.getInstance();
		
		Types t = this.expression.eval();
		
		handler.getStack().addVariableToActualScope(id.getId(), t);
		
		return new VoidType();
	}
	
}
