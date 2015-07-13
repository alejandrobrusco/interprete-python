package com.language.types;

import com.language.types.Types;

public class IntegerType extends Types {

	Integer value;
	
	public IntegerType(Integer value){
		this.value = value;
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.int_type;
	}
	
	@Override
	public Boolean toBooleanValue(){
		return this.value.intValue() !=0;
	}

	@Override
	public String print() {
		return String.valueOf(value);
	}
	
	public Integer getInteger(){
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
}
