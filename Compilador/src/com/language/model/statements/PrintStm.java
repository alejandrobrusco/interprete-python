package com.language.model.statements;

import java.util.ArrayList;
import java.util.List;

import com.language.model.expression.Expression;
import com.language.types.Types;
import com.language.types.VoidType;

public class PrintStm extends Statement {
	
	List<Expression> expressions;
	int line;
	
	public PrintStm(List<Expression> expressions, int line){
		this.expressions = expressions;
		this.line = line;
	}
	
	public Types eval() {
		if (!expressions.isEmpty()){
			List<Expression> expressionClone = new ArrayList<Expression>(this.expressions);
			Expression last = expressionClone.remove(expressionClone.size()-1);
			for (Expression expression : expressionClone) {
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
