package com.language.types;

public class VoidType extends Types {

	@Override
	public TypeEnum getType() {
		return TypeEnum.none_type;
	}

	@Override
	public void print() {
	}

	@Override
	public String toStringValue() {
		return null;
	}
}
