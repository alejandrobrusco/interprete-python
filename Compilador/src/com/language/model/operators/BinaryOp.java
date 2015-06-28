package com.language.model.operators;

import com.language.types.Types;

public enum BinaryOp {
	add, sub, mult, div, divInt, mod, pow,
	less, greater, lessOrEqual, greaterOrEqual, equal, notEqual,
	or, and,bAnd,bOr,bXor,bLShift,bRShift;

	public void print() {
		switch(this){
			case add: 
				System.out.print("+");
				break;
			case sub:
				System.out.print("-");
				break;
			case mult:
				System.out.print("*");
				break;
			case div:
				System.out.print("/");
				break;
			case divInt:
				System.out.print("//");
				break;
			case mod:
				System.out.print("%");
				break;
			case pow:
				System.out.print("**");
				break;
			case less:
				System.out.print("<");
				break;
			case greater:
				System.out.print(">");
				break;
			case greaterOrEqual:
				System.out.print(">=");
				break;
			case lessOrEqual:
				System.out.print("<=");
				break;
			case equal:
				System.out.print("==");
				break;
			case notEqual:
				System.out.print("!=");
				break;
			case and:
				System.out.print("and");
				break;
			case or:
				System.out.print("or");
				break;
			case bAnd:
				System.out.print("&");
				break;
			case bLShift:
				System.out.print("<<");
				break;
			case bOr:
				System.out.print("|");
				break;
			case bRShift:
				System.out.print(">>");
				break;
			case bXor:
				System.out.print("^");
				break;
		} 
	}
	
	public String translate(String obj1, String obj2, Types type1, Types type2) {
		if(type1 == Types.list_type || type2 == Types.list_type) {
			System.out.println("Error: Wrong types");
			System.exit(0);
		}
		
		switch(this){
			case add: 
				return "(+ " + obj1 + " " + obj2 + ")";
			case sub:
				return "(- " + obj1 + " " + obj2 + ")";
			case mult:
				return "(* " + obj1 + " " + obj2 + ")";
			case div:
				return "(/ " + obj1 + " " + obj2 + ")";
			case divInt:
				return "(// " + obj1 + " " + obj2 + ")";
			case mod:
				return "(mod " + obj1 + " " + obj2 + ")";
			case pow:
				return "(expt " + obj1 + " " + obj2 + " )";
			case less:
				return "(< " + obj1 + " " + obj2 + ")";
			case greater:
				return "(> " + obj1 + " " + obj2 + ")";
			case greaterOrEqual:
				return "(>= " + obj1 + " " + obj2 + ")";
			case lessOrEqual:
				return "(<= " + obj1 + " " + obj2 + ")";
			case equal:
				return "(= " + obj1 + " " + obj2 + ")";
			case notEqual:
				return "(/= " + obj1 + " " + obj2 + ")";
			case and:
				return "(and " + obj1 + " " + obj2 + ")";
			case or:
				return "(or " + obj1 + " " + obj2 + ")";
			case bAnd:
				return "(& " + obj1 + " " + obj2 + ")";
			case bLShift:
				return "(<< " + obj1 + " " + obj2 + ")";
			case bOr:
				return "(| " + obj1 + " " + obj2 + ")";
			case bRShift:
				return "(>> " + obj1 + " " + obj2 + ")";
			case bXor:
				return "(^ " + obj1 + " " + obj2 + ")";
		}
		return null;
	}

	public Object eval(Object eval, Object eval2) {
		// TODO Auto-generated method stub
		return null;
	}
}
