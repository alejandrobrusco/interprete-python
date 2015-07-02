package com.language.types;

import java.util.List;

import com.language.types.Types;

public class ListType extends Types {

	List<Types> value;
	
	public ListType(List<Types> value){
		this.value = value;
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.list_type;
	}

	@Override
	protected void print() {
		System.out.print("[");
		for (Types types : value) {
			System.out.print(types.toStringValue() + ",");
		}
		System.out.print("]");
	}
	
	public List<Types> getList() {
		return this.value;
	}

	@Override
	protected String toStringValue() {
		return this.value.toString();
	}
	

}
