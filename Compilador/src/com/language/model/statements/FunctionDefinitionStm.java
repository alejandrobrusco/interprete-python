package com.language.model.statements;

import java.util.Collections;
import java.util.List;

public class FunctionDefinitionStm implements Statement {

	String identifier;
	List<String> identifierList;
	List<Statement> statementList;
	
	public FunctionDefinitionStm(String identifier, List<String> identifierList, List<Statement> statementList) {
		this.identifier = identifier;
		Collections.reverse(identifierList);
		this.identifierList = identifierList;
		this.statementList = statementList;
	}
	
	public void eval() {
		// TODO - Revisar
	}
	
}
