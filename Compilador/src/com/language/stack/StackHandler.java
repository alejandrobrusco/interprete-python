package com.language.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.language.model.statements.FunctionDefinitionStm;


public class StackHandler {

	private static StackHandler instance = null;
	private Stack scopeStack;
	
	private List<Boolean> scopeReturn;
	private List<ControlVariable> scopeControlVariables; // lista para control de scope con break, continue
	private Map<String, FunctionDefinitionStm> functionDefinitions;// list for functions

	private StackHandler() {
		this.functionDefinitions = new HashMap<String, FunctionDefinitionStm>();
		
		this.scopeStack = new Stack();
		// el scope global
		this.scopeStack.openScope();
		
		this.scopeControlVariables = new ArrayList<ControlVariable>();
		ControlVariable controlVar = new ControlVariable();
		this.scopeControlVariables.add(controlVar);
		
		this.scopeReturn = new ArrayList<Boolean>();
		this.scopeReturn.add(Boolean.FALSE);

	}
	
	public static StackHandler getInstance() {
		if (instance == null) {
			instance = new StackHandler();
		}
		return instance;
	}
	
	public void reset() {
		functionDefinitions = new HashMap<String, FunctionDefinitionStm>();
		scopeStack = new Stack();
	}

	public Stack getStack() {
		return scopeStack;
	}

	public void addFunction(String id, FunctionDefinitionStm func) {
		this.functionDefinitions.put(id, func);
	}

	public FunctionDefinitionStm findFunction(String id) {
		
		boolean exist = this.functionDefinitions.containsKey(id);
		
		if (!exist){
			// EXCEPTION
			return null;
		}
		else{
			return this.functionDefinitions.get(id);
		}

	}
	
	public void openControlScope(){
		ControlVariable controlVar = new ControlVariable();
		this.scopeControlVariables.add(controlVar);
	}
	
	public void closeControlScope(){
		int last = this.scopeControlVariables.size()-1;
		this.scopeControlVariables.remove(last);
	}
	
	public void openReturnScope(){
		this.scopeReturn.add(Boolean.TRUE);
	}
	
	public void closeReturnScope(){
		int last = this.scopeReturn.size()-1;
		this.scopeReturn.remove(last);
	}
	
	public ControlVariable getActualScopeControlVariable(){
		int last = this.scopeControlVariables.size()-1;
		return this.scopeControlVariables.get(last);
	}
	
	public Boolean getScopeReturn(){
		int last = this.scopeReturn.size()-1;
		return this.scopeReturn.get(last);
	}
}
