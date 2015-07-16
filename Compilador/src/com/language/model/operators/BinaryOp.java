package com.language.model.operators;

public enum BinaryOp {
	add("+"), 
	sub("-"), 
	mult("*"), 
	div("/"), 
	divInt("//"), 
	mod("%"), 
	pow("**"),
	less("<"), 
	greater(">"), 
	lessOrEqual("<="), 
	greaterOrEqual(">="), 
	equal("=="), 
	notEqual("!="),
	or("or"), 
	and("and"), 
	bAnd("&"), 
	bOr("|"), 
	bXor("^"), 
	bLShift("<<"), 
	bRShift(">>");
	
	private String pyhtonType;
	
	BinaryOp(String pythonType){
		this.pyhtonType = pythonType;
	}
	
	public String getPythonType(){
		return this.pyhtonType;
	}
}
