package com.language.model.expression;

import com.language.model.operators.UnaryOp;
import com.language.types.Types;

public class UnaryExp extends Expression {

	UnaryOp operator;
	Expression expression;
	
	public UnaryExp(UnaryOp operator, Expression expression){
		this.operator = operator;
		this.expression = expression;
	}

	@Override
	public Types eval() {
		
		Types t = expression.eval();
		
		//if (t.getType().equals(TypeEnum.))
		
		return null;
	}

}
