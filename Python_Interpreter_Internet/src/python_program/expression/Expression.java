package python_program.expression;

import python_program.Types;

public abstract class Expression {

	public abstract void print();
	public abstract Types getType();
	public abstract String translate();

}
