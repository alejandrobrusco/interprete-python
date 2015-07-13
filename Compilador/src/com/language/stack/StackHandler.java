package com.language.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.language.exceptions.FunctionNotExistException;
import com.language.model.statements.FunctionDefinitionStm;


public class StackHandler {

	private static StackHandler instance = null;
	private Stack scopeStack;
	
	private List<FunctionScope> functionsScope;
	private List<Boolean> scopeReturn;
	private List<ControlVariable> scopeControlVariables; // lista para control de scope con break, continue
	private Map<String, FunctionDefinitionStm> globalFunctionDefinition;// list for functions

	private StackHandler() {
		this.globalFunctionDefinition = new HashMap<String, FunctionDefinitionStm>();
		
		this.functionsScope = new ArrayList<FunctionScope>();
		this.functionsScope.add(new FunctionScope());
		
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
		globalFunctionDefinition = new HashMap<String, FunctionDefinitionStm>();
		scopeStack = new Stack();
	}

	public Stack getStack() {
		return scopeStack;
	}
	
	

	public void addFunction(String id, FunctionDefinitionStm func) {
		int last = this.functionsScope.size()-1;
		this.functionsScope.get(last).addFunction(id, func);
	}
	
	public FunctionDefinitionStm findFunction(String id) {
		
		FunctionDefinitionStm result = null;
		
		boolean exist = false;
		ListIterator<FunctionScope> it = this.functionsScope.listIterator(this.functionsScope.size());
		
		while (it.hasPrevious() && !exist){
			
			FunctionScope functionScope = it.previous();
			FunctionDefinitionStm function = functionScope.getFunction(id);
			
			if (function!=null){
				exist = true;
				result = function;
			}
		}
		
		if (exist){
			return result;
		}
		else{
			throw new FunctionNotExistException("Function \'" + id + "\' is not defined.");
		}
		
//		boolean exist = this.globalFunctionDefinition.containsKey(id);
//		
//		if (!exist){
//			throw new FunctionNotExistException("Function \'" + id + "\' is not defined.");
//		}
//		else{
//			return this.globalFunctionDefinition.get(id);
//		}

	}
	
	public void openFunctionScope() {
		FunctionScope newScope = new FunctionScope();
		this.functionsScope.add(newScope);
	}

	public void closeFunctionScope() {
		int last = this.functionsScope.size()-1;
		this.functionsScope.remove(last);
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
