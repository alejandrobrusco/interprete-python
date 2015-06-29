package com.language.model.expression;

import com.language.types.Types;

public abstract class Expression {

	public abstract Types getType();
	public abstract Object eval();
	
}
