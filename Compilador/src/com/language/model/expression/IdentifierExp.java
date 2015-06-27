package com.language.model.expression;

import com.language.types.Types;

public class IdentifierExp implements Expression {

	String id;
	
	public IdentifierExp(String id){
		this.id = id;
	}
	
	public Types getType() {
		return Types.nondefined_type;
	}
	
	public String getId() {
		return this.id;
	}

	public Object eval() {
		// TODO - Revisar qué es lo que se tiene que hacer acá (almacenar un listado de variables, etc)
		//System.out.print(this.id);
		return null;
	}

}
