package com.language.types;

import com.language.types.Types;

public class LongType extends Types {

	Long value;
	
	public LongType(String value){
		this.value = new Long(value);
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.long_type;
	}

	@Override
	protected void print() {
		System.out.println(value);
	}
	
	public Long getLong() {
		return this.value;
	}

	@Override
	protected String toStringValue() {
		return String.valueOf(this.value);
	}
	
}
