package com.language.model.expression;

import com.language.types.FloatType;
import com.language.types.Types;

public class FloatExp extends Expression {

	Float value;
	int line;
	
	public FloatExp(String value, int line){
		this.value = new Float(value);
		this.line = line;
	}
	
	@Override
	public Types eval() {
		return new FloatType(value);
	}

}
