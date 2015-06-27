package com.language.model.expression;

import com.language.model.operators.UnaryOp;
import com.language.types.Types;

public class UnaryExp implements Expression {

	UnaryOp operator;
	Expression expression;
	
	public UnaryExp(UnaryOp operator, Expression expression){
		this.operator = operator;
		this.expression = expression;
	}
	
	public Types getType() {
		return expression.getType();
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
