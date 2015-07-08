package com.language.model.expression;

import com.language.types.Types;

public class StringExp extends Expression {

	String value;
	
	public StringExp(String value){
		this.value = value;
	}
	
	@Override
	public Types getType() {
		return Types.string_type;
	}
	
	@Override
	public Object eval() {
		return this.value;
	}

}
