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
	public TypeEnum getType() {
		return TypeEnum.dict_type;
	}

	@Override
	public void print() {
		System.out.print("{");
		if (!this.dic.isEmpty()){
			List<Types> list = new ArrayList<Types>();
			list.addAll(dic.keySet());
			Types first = list.remove(0);
			printElement(first);
			for (Types t : list) {
				System.out.print(", ");
				printElement(t);
			}
		}
		System.out.print("}");
	}

	private void printElement(Types t) {
		t.print();
		System.out.print(": ");
		dic.get(t).print();
	}
	
	public Map<Types, Types> getDic() {
		return this.dic;
	}

	@Override
	public String toStringValue() {
		return this.dic.toString();
	}
	

}
