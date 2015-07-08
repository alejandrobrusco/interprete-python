package com.language.model.expression;

import com.language.types.StringType;
import com.language.types.Types;

public class StringExp extends Expression {

	String value;
	
	public StringExp(String value){
		this.value = value;
	}
	
	@Override
	public Types eval() {
		return new StringType(this.value); 
	}

}
