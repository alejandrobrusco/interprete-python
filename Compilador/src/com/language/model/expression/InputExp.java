package com.language.model.expression;

import com.language.types.Types;

public class InputExp implements Expression {

	public InputExp(){
		
	}
	
	@Override
	public Types getType() {
		return Types.nondefined_type;
	}


	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
