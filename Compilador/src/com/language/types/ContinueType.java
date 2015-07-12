package com.language.types;

public class ContinueType extends Types{

	@Override
	public TypeEnum getType() {
		return TypeEnum.continue_type;
	}

	@Override
	public String print() {
		return this.getType().toString();
	}

	@Override
	public String toStringValue() {
		return this.getType().toString();
	}

}
