package com.language.model.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.language.types.DicType;
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
		Map<Types,Types> mapTypes = new HashMap<Types, Types>();
		for (Entry<Expression, Expression> entry : map.entrySet()) {
			Types keyType = entry.getKey().eval();
			Types valueType = entry.getValue().eval();
			mapTypes.put(keyType, valueType);
		}
		return new DicType(mapTypes);
	}
}
