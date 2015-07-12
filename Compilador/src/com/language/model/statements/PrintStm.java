package com.language.model.statements;

import java.util.List;

import com.language.model.expression.Expression;
import com.language.types.Types;
import com.language.types.VoidType;

public class PrintStm extends Statement {
	
	List<Expression> expressions;
	
	public PrintStm(List<Expression> expressions){
		this.expressions = expressions;
	}
	
	public Types eval() {
		if (expressions != null){
			Expression last = expressions.remove(expressions.size()-1);
			for (Expression expression : expressions) {
				Types eval = expression.eval();
				String toPrint = eval.print();
				System.out.print(toPrint + " ");
			}
			Types eval = last.eval();
			String toPrint = eval.print();
			System.out.println(toPrint);
		}
		return new VoidType();
	}
}
