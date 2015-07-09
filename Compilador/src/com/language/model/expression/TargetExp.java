package com.language.model.expression;

import com.language.types.Types;

public class TargetExp extends Expression {

	IdentifierExp id;
	Expression expr;
	
	public TargetExp(String id, Expression expr) {
		this.id = new IdentifierExp(id);
		this.expr = expr;
	}


	@Override
	public Types eval() {
		
		
		
	}

}
