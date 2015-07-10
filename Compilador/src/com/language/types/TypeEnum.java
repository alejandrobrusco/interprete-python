package com.language.types;

public enum TypeEnum {
	
	boolean_type("boolean"), int_type("int"), long_type("long"), float_type("float"),string_type("str"),list_type("list"),tuple_type("tuple"), dict_type("dict"), function_type(null), none_type("NoneType"), nondefined_type(null), type_type("type"),continue_type("continue"),break_type("break"),return_type("return");

	private String pyhtonType;
	
	TypeEnum(String pythonType){
		this.pyhtonType = pythonType;
	}
	
	public String getPythonType(){
		return this.pyhtonType;
	}
	
}
