package python_program.operators;

import python_program.Types;

public enum BinaryOperators {
	add, sub, mult, div, mod, pow,
	less, greater, lessorequal, greaterorequal, equal, notequal,
	or, and;

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
			case greaterorequal:
				System.out.print(">=");
				break;
			case lessorequal:
				System.out.print("<=");
				break;
			case equal:
				System.out.print("==");
				break;
			case notequal:
				System.out.print("!=");
				break;
			case and:
				System.out.print("and");
				break;
			case or:
				System.out.print("or");
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
			case mod:
				return "(mod " + obj1 + " " + obj2 + ")";
			case pow:
				return "(expt " + obj1 + " " + obj2 + " )";
			case less:
				return "(< " + obj1 + " " + obj2 + ")";
			case greater:
				return "(> " + obj1 + " " + obj2 + ")";
			case greaterorequal:
				return "(>= " + obj1 + " " + obj2 + ")";
			case lessorequal:
				return "(<= " + obj1 + " " + obj2 + ")";
			case equal:
				return "(= " + obj1 + " " + obj2 + ")";
			case notequal:
				return "(/= " + obj1 + " " + obj2 + ")";
			case and:
				return "(and " + obj1 + " " + obj2 + ")";
			case or:
				return "(or " + obj1 + " " + obj2 + ")";
		}
		return null;
	}
}
