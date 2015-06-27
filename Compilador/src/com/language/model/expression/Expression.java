package com.language.model.expression;

import com.language.types.Types;

public abstract interface Expression {

	public abstract Types getType();
	public abstract Object eval();
	
}
