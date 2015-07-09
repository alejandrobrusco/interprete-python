package com.language.model.expression;

import java.util.Scanner;

import com.language.types.StringType;
import com.language.types.Types;

public class RawInputExp extends Expression {

	Expression expression;
	
	public RawInputExp(){
		this.expression = null;
	}
	
	public RawInputExp(Expression expr){
		this.expression = expr;
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
