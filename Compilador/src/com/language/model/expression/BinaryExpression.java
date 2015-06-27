package com.language.model.expression;

import com.language.model.operators.BinaryOperators;
import com.language.types.Types;

public class BinaryExpression implements Expression {
	
	Expression expression1;
	BinaryOperators operator;
	Expression expression2;
	
	public BinaryExpression(Expression expression1, BinaryOperators operator, Expression expression2){
		this.expression1 = expression1;
		this.operator = operator;
		this.expression2 = expression2;
	}
	
	public Types getType() {
		return expression1.getType();
	}

	public Object eval() {
		return operator.eval(this.expression1.eval(),this.expression2.eval());
	}

}
