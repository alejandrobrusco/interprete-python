package com.language.types;

import com.language.types.Types;

public class LongType extends Types {

	Long value;
	
	public LongType(Long value){
		this.value = value;
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.long_type;
	}

	@Override
	public void print() {
		System.out.print(value);
	}
	
	public Long getLong() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
	
}
