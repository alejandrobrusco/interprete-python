package com.language.stack;

import java.util.HashMap;

import com.language.types.Types;

public class VariablesList {

	private HashMap<String, StackVariable> varList;

	public VariablesList() {
		varList = new HashMap<String, StackVariable>();
	}

	public void addVariable(String id, Types type) {
		StackVariable var = new StackVariable();
		var.setId(id);
		var.setType(type);
		varList.put(id, var);
	}

	public Types findVariable(String id) {
		Types t = null;
		StackVariable sVar = varList.get(id);
		if (sVar != null) {
			t = sVar.getType();
		}
		return t;
	}

	public void printList() {

		for (StackVariable sVar : varList.values()) {
			System.out.println("Variable: " + sVar.getId());
		}

	}

}
