package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;

public class ForStm extends Statement {

	String id; 
	Expression expression;
	List<Statement> statementList;
	
	public ForStm(String id,Expression expression, List<Statement> statementList){
		this.id = id;
		this.expression = expression;
		this.statementList = statementList;
	}
	
	@Override
	public void eval() {
		
	}
	
}
