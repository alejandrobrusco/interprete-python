package com.language.model.statements;

import com.language.model.expression.Expression;
import com.language.types.ReturnType;
import com.language.types.Types;

public class ReturnStm extends Statement {

	Expression expr;

	public ReturnStm(Expression expr) {
		this.expr = expr;
	}
	
	public Types eval() {
		Types evalType = expr.eval();
		Types returnType = new ReturnType(evalType);
		return returnType;
	}
	
}
