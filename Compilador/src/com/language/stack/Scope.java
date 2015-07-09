package com.language.stack;

import java.util.HashMap;

import com.language.types.Types;

public class Scope {

	private HashMap<String, ScopeVariable> varList;

	public Scope() {
		varList = new HashMap<String, ScopeVariable>();
	}

	public void addVariable(String id, Types type) {
		ScopeVariable var = new ScopeVariable();
		var.setId(id);
		var.setType(type);
		varList.put(id, var);
	}

	public Types findVariable(String id) {
		Types t = null;
		ScopeVariable sVar = varList.get(id);
		if (sVar != null) {
			t = sVar.getType();
		}
		return t;
	}

	public void printList() {

		for (ScopeVariable sVar : varList.values()) {
			System.out.println("Variable: " + sVar.getId());
		}

	}

}
