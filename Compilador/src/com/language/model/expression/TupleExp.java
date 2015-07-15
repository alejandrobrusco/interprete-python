package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import com.language.types.TupleType;
import com.language.types.Types;

public class TupleExp extends Expression {

	List<Expression> list;
	int line;
	
	public TupleExp(List<Expression> value, int line){
		this.list = value;
		this.line = line;
	}
	
	public Types eval() {
		ArrayList<Types> listTypes = new ArrayList<Types>();
		for (Expression expression : list) {
			Types eval = expression.eval();
			listTypes.add(eval);
		}
		return new TupleType(listTypes);
	}

}
