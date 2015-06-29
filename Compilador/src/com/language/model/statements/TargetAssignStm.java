package com.language.model.statements;

import com.language.model.expression.Expression;

public class TargetAssignStm extends Statement {

	Expression expr1;
	Expression expr2;
	
	public TargetAssignStm(Expression expr1, Expression expr2) {
		this.expr1= expr1;
		this.expr2 = expr2;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
