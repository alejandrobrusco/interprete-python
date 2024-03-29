package com.language.model.statements;

import java.util.Collections;
import java.util.List;

import com.language.stack.StackHandler;
import com.language.types.Types;
import com.language.types.VoidType;

public class FunctionDefinitionStm extends Statement {
	String identifier;
	List<String> parametersList;
	List<Statement> statementsList;
	int line;
	
	public FunctionDefinitionStm(String identifier, List<String> identifierList, List<Statement> statementList, int line) {
		this.identifier = identifier;
		Collections.reverse(identifierList);
		this.parametersList = identifierList;
		this.statementsList = statementList;
		this.line = line;
	}
	
	public List<String> getParametersList() {
		return this.parametersList;
	}

	public List<Statement> getStatemensList() {
		return this.statementsList;
	}
	
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		handler.addFunction(this.identifier, this);
		
		return new VoidType();
		
	}
}
