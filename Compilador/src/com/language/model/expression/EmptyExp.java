package com.language.model.expression;

import com.language.types.Types;

public class EmptyExp extends Expression {
	
	public EmptyExp(){
		return;
	}
	
	@Override
	public Types eval() {
		return null;
	}

}
