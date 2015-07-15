package com.language.model.statements;

import java.util.List;

import com.language.exceptions.TypeErrorException;
import com.language.model.expression.Expression;
import com.language.stack.ControlVariable;
import com.language.stack.StackHandler;
import com.language.types.BooleanType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class WhileStm extends Statement {

	Expression expression;
	List<Statement> statementList;
	int line;
	
	public WhileStm(Expression expression, List<Statement> statementList, int line){
		this.expression = expression;
		this.statementList = statementList;
		this.line = line;
	}

	@Override
	public Types eval() {
		StackHandler handler = StackHandler.getInstance();
		
		handler.openControlScope();
		
		ControlVariable controlVar = handler.getActualScopeControlVariable();
		controlVar.setBreakContext(true);
		controlVar.setContinueContext(true);
		
		Types condition = this.expression.eval();
		
		Types t = null;
		
		if (condition.toBooleanValue()!=null){
			boolean execute = condition.toBooleanValue();
			while (execute){
				
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
					if (condition.toBooleanValue()!=null){
						execute = condition.toBooleanValue();
					}
					else{
						// type Exception
						return null;
					}

				}
				else{
					execute = false;
				}
			}
			
			handler.closeControlScope();
			
			return t;
		}
		else{
			throw new TypeErrorException("Error at line " + this.line +": not correct type expression on sentence \'while\'");

		}
	}
	
	
}
