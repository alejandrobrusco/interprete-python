package com.language.types;

import com.language.types.Types;

public class FloatType extends Types {

	Float value;
	
	public FloatType(String value){
		this.value = new Float(value);
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.float_type;
	}

	@Override
	protected void print() {
		System.out.println(value);
	}
	
	public Float getFloat() {
		return this.value;
	}

	@Override
	protected String toStringValue() {
		return String.valueOf(this.value);
	}
	

}
