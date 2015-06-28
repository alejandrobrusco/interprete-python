package com.language.model.operators;

public enum UnaryOp {
	add, sub, not, bNot;

	public void print() {
		switch(this){
			case add:
				System.out.print("+");
				break;
			case sub:
				System.out.print("-");
				break;
			case not:
				System.out.print("not ");
				break;
			case bNot:
				System.out.print("~");
				break;
		}
	}
	
	public String translate(String obj1) {
		switch(this){
		case add:
			return "+ " + obj1;
		case sub:
			return "- " + obj1;
		case not:
			return "not " + obj1;
		case bNot:
			return "~ " + obj1;
		}
		return null;
		
	}
}
