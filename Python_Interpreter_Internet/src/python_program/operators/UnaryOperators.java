package python_program.operators;

public enum UnaryOperators {
	add, sub, not;

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
		}
		return null;
		
	}
}
