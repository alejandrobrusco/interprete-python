package com.language.types;

public class BreakType extends Types {

	@Override
	public TypeEnum getType() {
		return TypeEnum.break_type;
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
