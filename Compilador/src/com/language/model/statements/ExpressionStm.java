package com.language.model.statements;

import com.language.model.expression.Expression;
import com.language.types.Types;

public class ExpressionStm extends Statement {

	Expression expr;
	
	public ExpressionStm(Expression expr) {
		this.expr = expr;
	}
	
	public Types eval() {
		return this.expr.eval();
	}
	
}
