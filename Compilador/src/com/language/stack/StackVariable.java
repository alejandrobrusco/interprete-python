package com.language.stack;

import com.language.types.Types;

public class StackVariable {

	private String id;
	private Types type;

	StackVariable() {

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
