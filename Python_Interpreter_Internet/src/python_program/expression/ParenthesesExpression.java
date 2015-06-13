package python_program.expression;

import python_program.Types;

public class ParenthesesExpression extends Expression{
	
	Expression expression;
	
	public ParenthesesExpression(Expression expression){
		this.expression=expression;
	}

	@Override
	public void print() {
		System.out.print("(");
		expression.print();
		System.out.print(")");
	}

	@Override
	public Types getType() {
		return expression.getType();
	}

	@Override
	public String translate() {
		return expression.translate();
	}

}
