package com.language.model.expression;

import java.util.Scanner;

import com.language.types.StringType;
import com.language.types.Types;

public class RawInputExp extends Expression {

	Expression expression;
	int line;
	
	public RawInputExp(int line){
		this.expression = null;
		this.line = line;
	}
	
	public RawInputExp(Expression expr, int line){
		this.expression = expr;
		this.line = line;
	}
	
	@Override
	public Types eval() {
		if (expression != null){
			Types eval = expression.eval();
			if (eval != null){
				System.out.print(eval.toStringValue());
			}
		}
		Scanner input = new Scanner(System.in);
	    String lect = input.nextLine();
	    input.close();
		return new StringType(lect);
	}

}
