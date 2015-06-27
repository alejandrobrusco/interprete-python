package com.language.model.expression;

import com.language.types.Types;

public class ParenthesesExp implements Expression {

	Expression expression;
	
	public ParenthesesExp(Expression expression){
		this.expression=expression;
	}

	public Types getType() {
		return expression.getType();
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
