package com.language.types;

import java.util.List;

import com.language.types.Types;

public class ListType extends Types {

	List<Types> value;
	
	public ListType(){
		
	}
	
	public ListType(List<Types> value){
		this.value = value;
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.list_type;
	}

	@Override
	public String print() {
		String ret = "[";
		if (!this.value.isEmpty()){
			Types first = this.value.remove(0);
			ret = ret.concat(first.print());
			for (Types types : this.value) {
				ret = ret.concat("," + types.print());
			}
		}
		ret = ret.concat("]");
		return ret;
	}
	
	public List<Types> getList() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return this.value.toString();
	}
	
	public void setList(List<Types> value){
		this.value = value;
	}
	

}
