package com.language.model.expression;

import com.language.types.Types;

public class SubscriptionExp implements Expression {

	Expression expr1;
	Expression expr2;
	
	public SubscriptionExp(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public Types getType() {
		return expr2.getType();
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
