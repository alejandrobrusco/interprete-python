package com.language.model.expression;

import com.language.types.LongType;
import com.language.types.Types;

public class LongExp extends Expression {

	Long value;
	
	public LongExp(Long value){
		this.value = value;
	}
	
	@Override
	public Types eval() {
		return new LongType(value);
	}

}
