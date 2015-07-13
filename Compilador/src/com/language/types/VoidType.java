package com.language.types;

public class VoidType extends Types {

	@Override
	public TypeEnum getType() {
		return TypeEnum.none_type;
	}

	@Override
	public String print() {
		return this.getType().toString();
	}
	
	@Override
	public Boolean toBooleanValue(){
		return false;
	}

	@Override
	public String toStringValue() {
		return null;
	}
}
