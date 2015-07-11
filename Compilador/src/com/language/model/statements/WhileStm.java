package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.stack.StackHandler;
import com.language.types.BooleanType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class WhileStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	
	public WhileStm(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}

	@Override
	public Types eval() {
		StackHandler handler = StackHandler.getInstance();
		handler.setContextoBreak(true);
		handler.setContextoContinue(true);
		
		Types condition = this.expression.eval();
		
		Types t = null;
		
		if (condition.getType().equals(TypeEnum.boolean_type)){
			BooleanType condValue = (BooleanType) condition;
			while (condValue.getBoolean()){
				
				boolean evalCondition = true;
				
				for (Statement statment: statementList){
					t = statment.eval();
					
					if (t.getType().equals(TypeEnum.break_type)){
						evalCondition = false;
						break;
					}
					
					if (t.getType().equals(TypeEnum.continue_type)){
						break;
					}
					
					if (t.getType().equals(TypeEnum.return_type)){
						evalCondition = false;
						break;
					}
					
				}
				
				if (evalCondition){
					condition = this.expression.eval();
					if (condition.getType().equals(TypeEnum.boolean_type)){
						condValue = (BooleanType) condition;
					}
					else{
						// type Exception
						return null;
					}

				}
				else{
					condValue.setBoolean(Boolean.FALSE);
				}
			}
			
			return t;
		}
		else{
			// EXCEPTION: type error
			return null;
		}
	}
	
	
}
