package com.language.types;

import com.language.types.Types;

public class StringType extends Types {

	String value;
	
	public StringType(String value){
		this.value = new String(value);
	}

	@Override
	protected TypeEnum getType() {
		return TypeEnum.string_type;
	}

	@Override
	protected void print() {
		System.out.println(value);
	}
	
	public String getString() {
		return this.value;
	}

	@Override
	protected String toStringValue() {
		return String.valueOf(this.value);
	}


	

}
