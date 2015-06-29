package com.language.model.statements;

import com.language.model.expression.Expression;

public class ExpressionStm extends Statement {

	Expression expr;
	
	public ExpressionStm(Expression expr) {
		this.expr = expr;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
