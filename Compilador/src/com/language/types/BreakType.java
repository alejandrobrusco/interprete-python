package com.language.types;

public class BreakType extends Types {

	@Override
	public TypeEnum getType() {
		return TypeEnum.break_type;
	}

	@Override
	public void print() {
		System.out.print(this.getType());
	}

	@Override
	public String toStringValue() {
		return this.getType().toString();
	}

}
