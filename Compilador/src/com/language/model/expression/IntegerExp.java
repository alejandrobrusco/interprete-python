package com.language.model.expression;

import com.language.types.IntegerType;
import com.language.types.Types;

public class IntegerExp extends Expression {

	Integer value;
	int line;
	
	public IntegerExp(String value, int line){
		this.value = new Integer(value);
		this.line = line;
	}
	
	@Override
	public Types eval() {
		return new IntegerType(value);
	}

}
