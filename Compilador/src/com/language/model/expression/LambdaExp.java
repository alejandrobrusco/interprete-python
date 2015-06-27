package com.language.model.expression;

import java.util.Collections;
import java.util.List;
import com.language.types.Types;

public class LambdaExp implements Expression {

	List<String> identifierList;
	Expression expr;
	
	public LambdaExp(List<String> identifierList, Expression expr) {
		Collections.reverse(identifierList);
		this.identifierList = identifierList;
		this.expr = expr;
	}

	public Types getType() {
		return Types.function_type;
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
