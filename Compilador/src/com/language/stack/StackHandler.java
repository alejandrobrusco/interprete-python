package com.language.stack;

import java.util.HashMap;
import java.util.Map;

import com.language.model.statements.FunctionDefinitionStm;


public class StackHandler {

	private static StackHandler instance = null;
	private Stack scopeStack;
	private boolean contextReturn;
	private boolean contextBreak;
	private boolean contextContinue;
	
	private Map<String, FunctionDefinitionStm> functionDefinitions;// list for functions

	private StackHandler() {
		functionDefinitions = new HashMap<String, FunctionDefinitionStm>();
		scopeStack = new Stack();
		// el scope global
		scopeStack.openScope();
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

	public boolean isContextoReturn() {
		return contextReturn;
	}

	public void setContextoReturn(boolean contextoReturn) {
		this.contextReturn = contextoReturn;
	}

	public boolean isContextoBreak() {
		return contextBreak;
	}

	public void setContextoBreak(boolean contextoBreak) {
		this.contextBreak = contextoBreak;
	}

	public boolean isContextoContinue() {
		return contextContinue;
	}

	public void setContextoContinue(boolean contextoContinue) {
		this.contextContinue = contextoContinue;
	}
}
