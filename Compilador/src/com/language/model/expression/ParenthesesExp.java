package com.language.model.expression;

import com.language.types.Types;

public class ParenthesesExp extends Expression {

	Expression expression;
	
	public ParenthesesExp(Expression expression){
		this.expression=expression;
	}

	@Override
	public Types getType() {
		return expression.getType();
	}

	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
