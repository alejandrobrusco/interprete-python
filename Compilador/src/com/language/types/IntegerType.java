package com.language.types;

import com.language.types.Types;

public class IntegerType extends Types {

	Boolean value;
	
	public IntegerType(String value){
		this.value = new Boolean(value);
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.int_type;
	}

	@Override
	protected void print() {
		System.out.println(value);
	}
	
	public Boolean getInteger(){
		return this.value;
	}

	@Override
	protected String toStringValue() {
		return String.valueOf(this.value);
	}
}
