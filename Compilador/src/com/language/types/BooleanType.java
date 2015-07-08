package com.language.types;

import com.language.types.Types;

public class BooleanType extends Types {

	Boolean value;
	
	public BooleanType(Boolean value){
		this.value = new Boolean(value);
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.boolean_type;
	}

	@Override
	public void print() {
		System.out.println(value);
	}
	
	public Boolean getBoolean() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
	

}
