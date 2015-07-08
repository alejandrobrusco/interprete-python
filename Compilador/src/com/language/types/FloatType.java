package com.language.types;

import com.language.types.Types;

public class FloatType extends Types {

	Float value;
	
	public FloatType(String value){
		this.value = new Float(value);
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.float_type;
	}

	@Override
	public void print() {
		System.out.println(value);
	}
	
	public Float getFloat() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
	

}