package com.language.types;

import com.language.types.Types;

public class FloatType extends Types {

	Float value;
	
	public FloatType(Float value){
		this.value = new Float(value);
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.float_type;
	}
	
	@Override
	public Boolean toBooleanValue(){
		return this.value.floatValue() !=0;
	}

	@Override
	public String print() {
		return String.valueOf(value);
	}
	
	public Float getFloat() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return String.valueOf(this.value);
	}
	

}
