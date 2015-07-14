package com.language.model.statements;

import com.language.exceptions.TypeErrorException;
import com.language.model.expression.Expression;
import com.language.model.expression.TargetExp;
import com.language.types.Types;

public class TargetAssignStm extends Statement {

	Expression expr1;
	Expression expr2;
	
	public TargetAssignStm(Expression expr1, Expression expr2) {
		this.expr1= expr1;
		this.expr2 = expr2;
	}
	
	public Types eval() {
		
		if (expr1 instanceof TargetExp){
			
			TargetExp target = (TargetExp)expr1;
			
			target.assign(expr2);
			
			return expr2.eval();
			
		}
		else{
			throw new TypeErrorException("General parsing error on evaluating Target Expression");

		}
		
	}
	
}
