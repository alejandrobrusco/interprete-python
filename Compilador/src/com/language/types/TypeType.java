package com.language.types;

import com.language.types.Types;

public class TypeType extends Types {

	String type;
	
	public TypeType(String type){
		this.type = type;
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.type_type;
	}
	
	@Override
	public Boolean toBooleanValue(){
		return this.type.equals(TypeEnum.none_type.getPythonType());
	}

	@Override
	public String print() {
		return "<type '"+ type +"'>";
	}
	
	public String getTypeValue() {
		return this.type;
	}

	@Override
	public String toStringValue() {
		return type;
	}
	

}
