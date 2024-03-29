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
	public Boolean toBooleanValue(){
		return this.value.longValue() !=0;
	}

	@Override
	public String print() {
		return String.valueOf(value);
	}
	
	public Long getLong() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
	
}
