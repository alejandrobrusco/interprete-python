package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.model.statements.Statement;
import com.language.types.BooleanType;
import com.language.types.FloatType;
import com.language.types.IntegerType;
import com.language.types.LongType;
import com.language.types.TypeEnum;
import com.language.types.Types;
import com.language.types.VoidType;

public class IfStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	
	public IfStm(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}
	
	public Types eval() {
		Types eval = expression.eval();
		Types ret = null;
		if (eval.toBooleanValue()!= null && eval.toBooleanValue()){
			
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
		else{
			// EXCEPTION Type Error
			return null;
		}
		
		return ret;
	}
	
}
