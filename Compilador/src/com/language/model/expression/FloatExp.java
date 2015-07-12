package com.language.model.expression;

import com.language.types.FloatType;
import com.language.types.Types;

public class FloatExp extends Expression {

	Float value;
	
	public FloatExp(String value){
		this.value = new Float(value);
	}
	
	@Override
	public Types eval() {
		return new FloatType(value);
	}

}
