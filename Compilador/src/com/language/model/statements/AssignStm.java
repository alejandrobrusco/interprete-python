package com.language.model.statements;

import com.language.model.expression.Expression;
import com.language.model.expression.IdentifierExp;
import com.language.model.statements.Statement;

public class AssignStm extends Statement {

	IdentifierExp id;
	Expression expression;
	
	public AssignStm(IdentifierExp id, Expression expression){
		this.id = id;
		this.expression = expression;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
