package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;

public class WhileStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	
	public WhileStm(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
