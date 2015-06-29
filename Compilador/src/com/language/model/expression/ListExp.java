package com.language.model.expression;

import java.util.List;

import com.language.types.Types;

public class ListExp extends Expression {

	List<Expression> list;
	
	public ListExp(List<Expression> list) {
		this.list = list;
	}
	
	@Override
	public Types getType() {
		return Types.list_type;
	}

	@Override
	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
