package com.language.model.expression;

import com.language.model.operators.BinaryOp;
import com.language.types.Types;

public class BinaryExp implements Expression {
	
	Expression expression1;
	BinaryOp operator;
	Expression expression2;
	
	public BinaryExp(Expression expression1, BinaryOp operator, Expression expression2){
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
