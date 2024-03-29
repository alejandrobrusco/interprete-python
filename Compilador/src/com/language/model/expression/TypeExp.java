package com.language.model.expression;

import com.language.types.TypeType;
import com.language.types.Types;

public class TypeExp extends Expression {

	Expression expr;
	int line;
	
	public TypeExp(Expression expr, int line){
		this.expr = expr;
		this.line = line;
	}

	@Override
	public Types eval() {
		
		Types t = this.expr.eval();
		
		return new TypeType(t.getType().getPythonType());
		
	}

}
