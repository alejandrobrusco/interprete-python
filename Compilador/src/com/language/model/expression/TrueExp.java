package com.language.model.expression;

import com.language.types.BooleanType;
import com.language.types.Types;

public class TrueExp extends Expression {

	int line;
	
	public TrueExp(int line){
		this.line = line;
	}
	
	@Override
	public Types eval() {
		return new BooleanType(Boolean.TRUE);
	}

}
