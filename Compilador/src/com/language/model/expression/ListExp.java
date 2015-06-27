package com.language.model.expression;

import java.util.List;
import com.language.types.Types;

public class ListExp implements Expression {

	List<Expression> list;
	
	public ListExp(List<Expression> list) {
		this.list = list;
	}
	
	public Types getType() {
		return Types.list_type;
	}

	public Object eval() {
		// TODO - Revisar
		return null;
	}

}
