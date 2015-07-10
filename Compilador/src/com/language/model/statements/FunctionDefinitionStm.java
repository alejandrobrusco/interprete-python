package com.language.model.statements;

import java.util.Collections;
import java.util.List;

import com.language.types.Types;

public class FunctionDefinitionStm extends Statement {
	String identifier;
	List<String> parametersList;
	List<Statement> statementsList;
	
	public FunctionDefinitionStm(String identifier, List<String> identifierList, List<Statement> statementList) {
		this.identifier = identifier;
		Collections.reverse(identifierList);
		this.parametersList = identifierList;
		this.statementsList = statementList;
	}
	
	public List<String> getParametersList() {
		return this.parametersList;
	}

	public List<Statement> getStatemensList() {
		return this.statementsList;
	}
	
	public Types eval() {
		// no hace nada
		return null;
	}
}
