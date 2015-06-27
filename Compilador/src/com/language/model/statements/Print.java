package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;

public class Print implements Statement {
	
	List<Expression> expressions;
	
	public Print(List<Expression> expressions){
		this.expressions = expressions;
	}
	
	public void eval() {
		if (expressions != null){
			for (Expression expression : expressions) {
				System.out.print(expression.eval()+" ");
			}
		}
	}
}
