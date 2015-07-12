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
	public void print() {
		System.out.print(value);
	}
	
	public String getString() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}


	

}
