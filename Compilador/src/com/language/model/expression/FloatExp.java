package com.language.model.expression;

import com.language.types.Types;

public class FloatExp implements Expression {

	String value;
	
	public FloatExp(String value){
		this.value = value;
	}
	
	public Types getType() {
		return Types.float_type;
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
