package com.language.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicType extends Types {

	Map<Types,Types> dic;
	
	public DicType(){
	}
	
	public DicType(Map<Types,Types> map){
		this.dic = map;
	}
	
	@Override
	public Boolean toBooleanValue(){
		return !dic.isEmpty();
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.dict_type;
	}

	@Override
	public String print() {
		 String ret = "{";
		if (this.dic != null && !this.dic.isEmpty()){
			List<Types> list = new ArrayList<Types>();
			list.addAll(dic.keySet());
			Types first = list.remove(0);
			ret = ret.concat(printElement(first));
			for (Types t : list) {
				ret = ret.concat(", ");
				ret = ret.concat(printElement(t));
			}
		}
		ret = ret.concat("}");
		return ret;
	}

	private String printElement(Types t) {
		
		String toPrintKey = t.print();
		
		if (t.getType().equals(TypeEnum.string_type)){
			toPrintKey = "'" + t.print() + "'";
		}
		
		String ret = toPrintKey;
		String toPrintValue = this.dic.get(t).print();
		
		if (this.dic.get(t).getType().equals(TypeEnum.string_type)){
			toPrintValue = "'" + toPrintValue + "'";
		}
		
		ret = ret.concat(": " + toPrintValue);
		return ret;
	}
	
	public Map<Types, Types> getDic() {
		return this.dic;
	}

	@Override
	public String toStringValue() {
		return this.dic.toString();
	}
	

}
