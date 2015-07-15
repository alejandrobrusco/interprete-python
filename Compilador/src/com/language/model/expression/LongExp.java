package com.language.model.expression;

import com.language.types.LongType;
import com.language.types.Types;

public class LongExp extends Expression {

	Long value;
	int line;
	
	public LongExp(String value, int line){
		int endIndex = value.length()-1;
		char charAt = value.charAt(endIndex);
		if ("l".equalsIgnoreCase(String.valueOf(charAt))) {
			value = value.substring(0, endIndex);
		}
		this.value = new Long(value);
		this.line = line;
	}
	
	@Override
	public Types eval() {
		return new LongType(value);
	}

}
