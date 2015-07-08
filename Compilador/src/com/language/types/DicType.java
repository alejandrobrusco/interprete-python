package com.language.types;

import java.util.List;
import java.util.Map;

import com.language.types.Types;

public class DicType extends Types {

	Map<Types,Types> dic;
	
	public DicType(Map<Types,Types> map){
		this.dic = map;
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.dict_type;
	}

	@Override
	protected void print() {
		
	}
	
	public Map<Types, Types> getDic() {
		return this.dic;
	}

	@Override
	protected String toStringValue() {
		return this.dic.toString();
	}
	

}
