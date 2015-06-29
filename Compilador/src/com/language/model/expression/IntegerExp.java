package com.language.model.expression;

import com.language.types.Types;

public class IntegerExp extends Expression {

	String value;
	
	public IntegerExp(String value){
		this.value = value;
	}
	
	@Override
	public Types getType() {
		return Types.int_type;
	}
	
	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
