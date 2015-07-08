package com.language.model.expression;

import com.language.types.Types;

public class LongExp extends Expression {

	Long value;
	
	public LongExp(Long value){
		this.value = value;
	}
	
	@Override
	public Types getType() {
		return Types.long_type;
	}
	
	@Override
	public Object eval() {
		return this.value;
	}

}
