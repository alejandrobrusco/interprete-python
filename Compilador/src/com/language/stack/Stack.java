package com.language.stack;

import java.util.ArrayList;
import java.util.List;
import com.language.types.LinkType;
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
	
	public void printStack() {

		System.out.println("-------Stack--------");
		for (int j = stackList.size() - 1; j >= 0; j--) {
			System.out.println("Scope: " + j);
			stackList.get(j).printList();
		}
		System.out.println("------fin Stack-----");

	}
	
	private Types findVariableWithLevel (String id,int scopeLevel){
		Types variable;
		while (scopeLevel!=-1){
			variable = this.stackList.get(scopeLevel).findVariable(id);
			scopeLevel--;
			if (variable != null){
				if (variable instanceof LinkType){
					return findVariableWithLevel(((LinkType)variable).getLinkedVariable(), scopeLevel);
				} else {
					return variable;
				}
			}
		}
		return null;
	}
	
	public Types findVariable (String id){
		return findVariableWithLevel(id,this.stackList.size()-1);
	}
		
}
