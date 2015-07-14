package com.language.model.operators;

public enum UnaryOp {
	add("+"), sub("-"), not("not"), bNot("~");
	
	UnaryOp(String pythonOperation){
		this.pythonOperation = pythonOperation;
	}
	
	private String pythonOperation;
	
	public String getPythonOperation(){
		return this.pythonOperation;
	}
	
	
}
