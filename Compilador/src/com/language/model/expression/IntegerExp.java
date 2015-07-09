package com.language.model.expression;

import com.language.types.IntegerType;
import com.language.types.Types;

public class IntegerExp extends Expression {

	Integer value;
	
	public IntegerExp(String value){
		this.value = new Integer(value);
	}
	
	@Override
	public Types eval() {
		return new IntegerType(value);
	}

}
