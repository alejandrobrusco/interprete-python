package com.language.model.expression;

import com.language.types.Types;

public class RawInputExp extends Expression {

	
	
	public RawInputExp(){
		
	}
	
	public RawInputExp(Expression expr){
		
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
