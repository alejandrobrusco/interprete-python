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
	
//	public Types findInActualScope(String id) {
//		Scope vList = stackList.get(stackList.size() - 1);
//		Types findVariable = vList.findVariable(id);
//		
//		if (findVariable != null && findVariable.getType().equals(TypeEnum.link_type)){
//			Types variable = findInOtherScopes(((LinkType)findVariable).getLinkedVariable());
//			return variable;
//		}
//		
//		return findVariable;
//	}

	public void printStack() {

		System.out.println("-------Stack--------");
		for (int j = stackList.size() - 1; j >= 0; j--) {
			System.out.println("Scope: " + j);
			stackList.get(j).printList();
		}
		System.out.println("------fin Stack-----");

	}
	
//	public Types findInGlobalScope(String id){
//		Scope globalScope = this.stackList.get(0);
//		return globalScope.findVariable(id);
//		
//	}
	
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
		
//	public Types findInOtherScopes(String id) {
//		
//		Types result = null;
//		
//		boolean exist = false;
//		ListIterator<Scope> it = this.stackList.listIterator(this.stackList.size()-1);
//		
//		while (it.hasPrevious() && !exist){
//			
//			Scope scope = it.previous();
//			Types variable = scope.findVariable(id);
//			
//			if (variable!=null){
//				exist = true;
//				result = variable;
//			}
//		}
//		
//		if (exist){
//			return result;
//		}
//		else{
//			throw new  VariableNotExistException("General Error searching LinkType");
//		}
//
//	}

}
