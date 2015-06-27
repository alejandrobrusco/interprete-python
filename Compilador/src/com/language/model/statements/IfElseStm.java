package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.model.statements.Statement;

public class IfElseStm implements Statement {

	Expression expression;
	List<Statement> ifStatementList;
	List<Statement> elseStatementList;
	
	public IfElseStm(Expression expression, List<Statement> ifStatementList, List<Statement> elseStatementList){
		this.expression = expression;
		this.ifStatementList = ifStatementList;
		this.elseStatementList = elseStatementList;
	}
	
	public void eval() {
		if ((boolean) expression.eval()){
			if (ifStatementList != null){
				for (Statement statement : ifStatementList) {
					statement.eval();
				}
			}
		} else {
			if (elseStatementList != null){
				for (Statement statement : elseStatementList) {
					statement.eval();
				}
			}
		}
	}
	
}
