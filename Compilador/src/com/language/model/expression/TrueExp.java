package com.language.model.expression;

import com.language.types.Types;

public class TrueExp extends Expression {

	public TrueExp(){
		
	}
	
	@Override
	public Types getType() {
		return Types.boolean_type;
	}
	
	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
