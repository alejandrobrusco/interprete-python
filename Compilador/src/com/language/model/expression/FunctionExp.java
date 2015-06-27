package com.language.model.expression;

import java.util.List;

import com.language.types.Types;

public class FunctionExp implements Expression {

	Expression expr;
	List<Expression> expressionList;
	
	public FunctionExp(Expression expr, List<Expression> expressionList) {
		this.expr = expr;
		this.expressionList = expressionList;
	}

	@Override
	public Types getType() {
		return Types.none_type;
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
