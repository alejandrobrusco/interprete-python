package com.language.model.statements;

import com.language.model.expression.Expression;

public class ReturnStm extends Statement {

	Expression expr;

	public ReturnStm(Expression expr) {
		this.expr = expr;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
