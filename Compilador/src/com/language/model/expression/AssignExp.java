package com.language.model.expression;

import com.language.model.expression.Expression;
import com.language.types.Types;
import com.language.types.VoidType;

public class AssignExp extends Expression {

	private Expression id;
	private Expression expression;
	private int line;
	
	public AssignExp(Expression id, Expression expression,int line){
		this.id = id;
		this.expression = expression;
		this.line = line;
	}
	
	public Expression getId(){
		return id;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public Types eval(){
		return new VoidType();
	}

	public int getLine() {
		return line;
	}
	
}
