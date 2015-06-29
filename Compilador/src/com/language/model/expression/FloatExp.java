package com.language.model.expression;

import com.language.types.Types;

public class FloatExp extends Expression {

	String value;
	
	public FloatExp(String value){
		this.value = value;
	}
	
	@Override
	public Types getType() {
		return Types.float_type;
	}

	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
