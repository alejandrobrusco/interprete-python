package com.language.model.expression;

import com.language.types.Types;

public class ParenthesesExp extends Expression {

	Expression expression;
	int line;
	
	public ParenthesesExp(Expression expression, int line){
		this.expression=expression;
		this.line = line;
	}

	@Override
	public Types eval() {
		return this.expression.eval();
	}

}
