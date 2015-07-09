package com.language.stack;

import java.util.ArrayList;
import java.util.List;

import com.language.types.Types;

public class Stack {

	private List<Scope> stackList;

	public Stack() {
		stackList = new ArrayList<Scope>();
	}

	public void openScope() {
		Scope l = new Scope();
		stackList.add(l);
	}

	public void closeScope() {
		stackList.remove(stackList.size() - 1);
	}

	public void addVariableToActualScope(String id, Types t) {
		if (stackList != null && !stackList.isEmpty())
			stackList.get(stackList.size() - 1).addVariable(id, t);
	}

	public Types findInActualScope(String id) {
		Scope vList = stackList.get(stackList.size() - 1);
		return (vList.findVariable(id));
	}

	public void printStack() {

		System.out.println("-------Stack--------");
		for (int j = stackList.size() - 1; j >= 0; j--) {
			System.out.println("Scope: " + j);
			stackList.get(j).printList();
		}
		System.out.println("------fin Stack-----");

	}
	
	public Types findInGlobalScope(String id){
		Scope globalScope = this.stackList.get(0);
		
		return globalScope.findVariable(id);
		
	}

}
