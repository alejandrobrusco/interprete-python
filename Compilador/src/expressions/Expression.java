package expressions;

import types.Types;

public abstract interface Expression {

	public abstract void print();
	public abstract Types getType();
	public abstract Object eval();
	
}
