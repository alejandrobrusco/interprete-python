package com.language.model.expression;

import com.language.types.Types;
import com.language.types.VoidType;

public class EmptyExp extends Expression {
	
	public EmptyExp(){
		return;
	}
	
	@Override
	public Types eval() {
		return new VoidType();
	}

}
