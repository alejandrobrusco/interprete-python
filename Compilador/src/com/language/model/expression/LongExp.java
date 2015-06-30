package com.language.model.expression;

import com.language.types.Types;

public class LongExp extends Expression {

	Long value;
	
	public LongExp(String value){
		this.value = new Long(value);
	}
	
	@Override
	public Types getType() {
		return Types.long_type;
	}
	
	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
