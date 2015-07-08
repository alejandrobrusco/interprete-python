package com.language.types;

import com.language.types.Types;

public class LongType extends Types {

	Long value;
	
	public LongType(String value){
		this.value = new Long(value);
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.long_type;
	}

	@Override
	public void print() {
		System.out.println(value);
	}
	
	public Long getLong() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
	
}
