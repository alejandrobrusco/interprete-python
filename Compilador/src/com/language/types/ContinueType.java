package com.language.types;

public class ContinueType extends Types{

	@Override
	public TypeEnum getType() {
		return TypeEnum.continue_type;
	}

	@Override
	public void print() {
		System.out.println(this.getType());
	}

	@Override
	public String toStringValue() {
		return this.getType().toString();
	}

}
