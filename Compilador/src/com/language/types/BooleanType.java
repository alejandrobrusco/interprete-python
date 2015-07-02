package com.language.types;

import com.language.types.Types;

public class BooleanType extends Types {

	Float value;
	
	public BooleanType(String value){
		this.value = new Float(value);
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.boolean_type;
	}

	@Override
	protected void print() {
		System.out.println(value);
	}
	
	public Float getBoolean() {
		return this.value;
	}

	@Override
	protected String toStringValue() {
		return String.valueOf(this.value);
	}
	

}
