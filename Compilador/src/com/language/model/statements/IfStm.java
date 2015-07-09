package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.model.statements.Statement;
import com.language.types.BooleanType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class IfStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	
	public IfStm(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}
	
	public void eval() {
		Types eval = expression.eval();
		if (TypeEnum.boolean_type.equals(eval.getType()) && ((BooleanType)eval).getBoolean()){
			if (statementList != null){
				for (Statement statement : statementList) {
					statement.eval();
				}
			}
		}
	}
	
}
