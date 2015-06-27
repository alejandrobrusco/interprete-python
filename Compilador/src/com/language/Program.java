package com.language;

import java.util.List;

import com.language.model.statements.Statement;

public class Program {
	List<Statement> statements;
	
	public Program(List<Statement> statements){
		this.statements = statements;
	}
	
	public void eval() {
		if (statements != null){
			for (Statement statement : statements) {
				statement.eval();
			}
		}
	}
}
