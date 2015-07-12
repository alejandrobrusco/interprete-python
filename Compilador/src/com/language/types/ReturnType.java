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
	public String print() {
		return value.print();		
	}

	@Override
	public String toStringValue() {
		return value.toStringValue();
	}

	public Types getValueType(){
		return this.value;
	}
}
