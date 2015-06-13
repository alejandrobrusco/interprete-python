package python_program.expression;

import python_program.Types;

public class FalseExpression extends Expression {
	
	public FalseExpression(){
		
	}
	
	@Override
	public void print() {
		System.out.print("False");
	}

	@Override
	public Types getType() {
		return Types.boolean_type;
	}

	@Override
	public String translate() {
		return "NIL";
	}

}
