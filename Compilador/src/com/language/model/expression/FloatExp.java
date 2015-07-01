package com.language.model.expression;

import com.language.types.Types;

public class FloatExp extends Expression {

	Float value;
	
	public FloatExp(Float value){
		this.value = value;
	}
	
	@Override
	public Types getType() {
		return Types.float_type;
	}

	@Override
	public Object eval() {
		return this.value;
	}

}
