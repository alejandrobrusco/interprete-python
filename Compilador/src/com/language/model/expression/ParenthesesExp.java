package com.language.model.expression;

import com.language.types.Types;

public class ParenthesesExp extends Expression {

	Expression expression;
	
	public ParenthesesExp(Expression expression){
		this.expression=expression;
	}

	@Override
	public Types eval() {
		return this.expression.eval();
	}

}
