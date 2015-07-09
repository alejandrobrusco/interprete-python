package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.model.statements.Statement;
import com.language.types.BooleanType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class IfElseStm extends Statement {

	Expression expression;
	List<Statement> ifStatementList;
	List<Statement> elseStatementList;
	
	public IfElseStm(Expression expression, List<Statement> ifStatementList, List<Statement> elseStatementList){
		this.expression = expression;
		this.ifStatementList = ifStatementList;
		this.elseStatementList = elseStatementList;
	}
	
	public void eval() {
		Types eval = expression.eval();
		if (TypeEnum.boolean_type.equals(eval.getType()) && ((BooleanType)eval).getBoolean()){
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
