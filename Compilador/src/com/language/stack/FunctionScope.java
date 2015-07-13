package com.language.stack;

import java.util.HashMap;
import java.util.Map;

import com.language.model.statements.FunctionDefinitionStm;

public class FunctionScope {
	
	Map<String, FunctionDefinitionStm> functions;
	
	public FunctionScope(){
		this.functions = new HashMap<String,FunctionDefinitionStm>();
	}
	
	public void addFunction(String id, FunctionDefinitionStm function){
		functions.put(id, function);
	}
	
	public FunctionDefinitionStm getFunction(String id){
		return functions.get(id);
	}
	
	
}
