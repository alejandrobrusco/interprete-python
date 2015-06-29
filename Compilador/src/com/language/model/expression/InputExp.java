package com.language.model.expression;

import com.language.types.Types;

public class InputExp extends Expression {

	public InputExp(){
		
	}
	
	@Override
	public Types getType() {
		return Types.nondefined_type;
	}

	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
