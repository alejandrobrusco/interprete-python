package com.language.model.statements;

import com.language.model.expression.Expression;

public class ExpressionStm implements Statement {

	Expression expr;
	
	public ExpressionStm(Expression expr) {
		this.expr = expr;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
