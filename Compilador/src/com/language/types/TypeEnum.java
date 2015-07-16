package com.language.types;

public enum TypeEnum {
	
	boolean_type("boolean",0), int_type("int",1), long_type("long",2), float_type("float",3),string_type("str",4),list_type("list",5),tuple_type("tuple",6), dict_type("dict",7), function_type(null,8), none_type("NoneType",9), nondefined_type(null,10), type_type("type",11),continue_type("continue",12),break_type("break",13),return_type("return",14), index_type("index",15);

	private String pyhtonType;
	private int hashCode;
	
	TypeEnum(String pythonType, int hashCode){
		this.pyhtonType = pythonType;
		this.hashCode = hashCode;
	}
	
	public String getPythonType(){
		return this.pyhtonType;
	}
	
	public int getHashCode(){
		return this.hashCode;
	}
}
