package com.language.model.expression;

import com.language.types.TypeType;
import com.language.types.Types;

public class TypeExp extends Expression {

	Expression expr;
	
	public TypeExp(Expression expr){
		this.expr = expr;
	}

	@Override
	public Types eval() {
		
		Types t = this.expr.eval();
		
		return new TypeType(t.getType().getPythonType());
		
	}

}
