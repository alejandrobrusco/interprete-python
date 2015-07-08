package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import com.language.types.ListType;
import com.language.types.Types;

public class ListExp extends Expression {

	List<Expression> list;
	
	public ListExp(List<Expression> list) {
		this.list = list;
	}

	@Override
	public Types eval() {
		
		List<Types> resultValues = new ArrayList<Types>();
		
		for (Expression e: this.list){
			resultValues.add(e.eval());
		}
		
		return new ListType(resultValues);
		
	}

}
