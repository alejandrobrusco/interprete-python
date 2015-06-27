package com.language.model.expression;

import com.language.types.Types;

public class TrueExp implements Expression {

	public TrueExp(){
		
	}
	
	public Types getType() {
		return Types.boolean_type;
	}
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
