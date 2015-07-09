package com.language.stack;

import com.language.types.Types;

public class ScopeVariable {

	private String id;
	private Types type;

	public ScopeVariable() {

	}

	void setId(String s) {
		id = s;
	}

	void setType(Types t) {
		type = t;
	}

	String getId() {
		return id;
	}

	Types getType() {
		return type;
	}

}
