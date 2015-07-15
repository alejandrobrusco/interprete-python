package com.language.model.expression;

import com.language.model.expression.Expression;
import com.language.model.expression.IdentifierExp;
import com.language.types.Types;
import com.language.types.VoidType;

public class AssignExp extends Expression {

	IdentifierExp id;
	private Expression expression;
	
	public AssignExp(IdentifierExp id, Expression expression){
		this.id = id;
		this.expression = expression;
	}
	
	public IdentifierExp getId(){
		return id;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public Types eval(){
		
		return new VoidType();
	}


	
}
