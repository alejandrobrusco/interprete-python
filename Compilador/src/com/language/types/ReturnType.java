package com.language.types;

public class ReturnType extends Types{

	Types value;
	
	public ReturnType(Types value){
		this.value = value;
	}
	
	@Override
	public TypeEnum getType() {
		return TypeEnum.return_type;
	}

	@Override
	public void print() {
		System.out.print(value.toStringValue());		
	}

	@Override
	public String toStringValue() {
		return value.toStringValue();
	}

	public Types getValueType(){
		return this.value;
	}
}
