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
	public TypeEnum getType() {
		return TypeEnum.dict_type;
	}

	@Override
	public void print() {
		
	}
	
	public Map<Types, Types> getDic() {
		return this.dic;
	}

	@Override
	public String toStringValue() {
		return this.dic.toString();
	}
	

}
