package com.language.types;

import java.util.Map;

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
		System.out.println(dic.toString());
	}
	
	public Map<Types, Types> getDic() {
		return this.dic;
	}

	@Override
	public String toStringValue() {
		return this.dic.toString();
	}
	

}
