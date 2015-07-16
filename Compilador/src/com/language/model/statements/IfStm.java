package com.language.model.statements;

import java.util.List;

import com.language.exceptions.TypeErrorException;
import com.language.model.expression.Expression;
import com.language.model.statements.Statement;
import com.language.types.BooleanType;
import com.language.types.TypeEnum;
import com.language.types.Types;
import com.language.types.VoidType;

public class IfStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	int line;
	
	public IfStm(Expression expression, List<Statement> statementList, int line){
		this.expression = expression;
		this.statementList = statementList;
		this.line = line;
	}
	
	public Types eval() {
		Types eval = expression.eval();
		Types ret = null;
		if (eval.toBooleanValue()!= null) {
			if (eval.toBooleanValue()){
				if(((BooleanType)eval).getBoolean().equals(Boolean.TRUE)){
			
					if (statementList != null){
						for (Statement statement : statementList) {
							ret = statement.eval();
							
							if (ret.getType().equals(TypeEnum.break_type) || ret.getType().equals(TypeEnum.continue_type) || ret.getType().equals(TypeEnum.return_type)){
								break;
							}
						}
					}
				}
				else{
					return new VoidType();
				}
			}
		}
		else{
			throw new TypeErrorException("Error at line " + this.line +": not correct type expression on sentence \'if\'");

		}
		
		return ret;
	}
	
}
