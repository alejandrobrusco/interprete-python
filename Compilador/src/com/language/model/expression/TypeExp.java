package com.language.model.expression;

import com.language.types.Types;

public class TypeExp extends Expression {

	Expression expr;
	
	public TypeExp(Expression expr){
		this.expr = expr;
	}
	
	@Override
	public Types getType() {
		return Types.nondefined_type;
	}
	
	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
