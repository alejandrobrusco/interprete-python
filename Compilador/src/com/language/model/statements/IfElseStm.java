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
	
	public Types eval() {
		Types eval = expression.eval();
		Types ret = null;
		if (eval.toBooleanValue()!=null){
			if (eval.toBooleanValue()){
				if (ifStatementList != null){
					for (Statement statement : ifStatementList) {
						ret = statement.eval();
						
						if (ret.getType().equals(TypeEnum.break_type) || ret.getType().equals(TypeEnum.continue_type) || ret.getType().equals(TypeEnum.return_type)){
							break;
						}
					}
				}
			} else {
				if (elseStatementList != null){
					for (Statement statement : elseStatementList) {
						ret = statement.eval();
						
						if (ret.getType().equals(TypeEnum.break_type) || ret.getType().equals(TypeEnum.continue_type) || ret.getType().equals(TypeEnum.return_type)){
							break;
						}
					}
				}
			}
			
			return ret;
		}
		else{
			// Type Error
			return null;
		}
	}
	
}
