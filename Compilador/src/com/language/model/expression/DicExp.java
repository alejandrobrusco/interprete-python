package com.language.model.expression;

import java.util.Map;

import com.language.types.Types;

public class DicExp extends Expression {
	
	Map<Expression,Expression> map;
	
	public DicExp(Map<Expression,Expression> map){
		this.map = map;
	}
	
	public void put(Expression key, Expression value){
		map.put(key, value);
	}

	@Override
	public Types eval() {
		return null;
	}
}
