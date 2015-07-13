package com.language.types;

import com.language.types.Types;

public class StringType extends Types {

	String value;
	
	public StringType(String value){
		this.value = new String(value);
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.string_type;
	}

	@Override
	public String print() {
		return value;
	}
	
	@Override
	public Boolean toBooleanValue(){
		return !this.value.isEmpty();
	}
	
	public String getString() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}


	

}
