package com.language.model.expression;

import com.language.types.Types;

public class IntegerExp extends Expression {

	Integer value;
	
	public IntegerExp(Integer value){
		this.value = value;
	}
	
	@Override
	public Types getType() {
		return Types.int_type;
	}
	
	@Override
	public Object eval() {
		return this.value;
	}

}
