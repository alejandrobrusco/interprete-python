package com.language.types;

import java.util.List;

import com.language.types.Types;

public class DicType extends Types {

	List<DicElement> value;
	
	public DicType(List<Types> value){
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
