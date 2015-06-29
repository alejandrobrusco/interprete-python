package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.model.statements.Statement;

public class IfStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	
	public IfStm(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}
	
	public void eval() {
		if ((boolean) expression.eval()){
			if (statementList != null){
				for (Statement statement : statementList) {
					statement.eval();
				}
			}
		}
	}
	
}
