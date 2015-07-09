package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.types.Types;

public class PrintStm extends Statement {
	
	List<Expression> expressions;
	
	public PrintStm(List<Expression> expressions){
		this.expressions = expressions;
	}
	
	public void eval() {
		if (expressions != null){
			for (Expression expression : expressions) {
				Types eval = expression.eval();
				String stringValue = eval.toStringValue();
				System.out.print(stringValue+" ");
			}
		}
	}
}
