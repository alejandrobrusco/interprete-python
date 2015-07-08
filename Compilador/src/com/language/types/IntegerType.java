package com.language.types;

import com.language.types.Types;

public class IntegerType extends Types {

	Boolean value;
	
	public IntegerType(String value){
		this.value = new Boolean(value);
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.int_type;
	}

	@Override
	public void print() {
		System.out.println(value);
	}
	
	public Boolean getInteger(){
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
}
