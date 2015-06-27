package com.language.model.expression;

import com.language.types.Types;

public class IntegerExp implements Expression {

	String value;
	
	public IntegerExp(String value){
		this.value = value;
	}
	
	public Types getType() {
		return Types.int_type;
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
