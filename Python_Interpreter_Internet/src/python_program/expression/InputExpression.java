package python_program.expression;

import python_program.Types;

public class InputExpression extends Expression {
	
	public InputExpression(){
		
	}
	
	@Override
	public void print() {
		System.out.print("input ()");
	}

	@Override
	public Types getType() {
		return Types.nondefined_type;
	}

	@Override
	public String translate() {
		return "(read)";
	}

}
