package com.language.model.expression;

import com.language.types.Types;

public class IdentifierExp extends Expression {

	String id;
	
	public IdentifierExp(String id){
		this.id = id;
	}
	
	@Override
	public Types getType() {
		// buscar en las variavles para retornar el tipo
	}
	
	public String getId() {
		return this.id;
	}

	@Override
	public Types eval() {
		
		// Retorna valor según el stack de variables
		
	}

}
