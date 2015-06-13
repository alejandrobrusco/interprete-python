package python_program.expression;

import python_program.Types;
import python_program.operators.UnaryOperators;

public class UnaryExpression extends Expression {
	
	UnaryOperators operator;
	Expression expression;
	
	public UnaryExpression(UnaryOperators operator, Expression expression){
		this.operator = operator;
		this.expression = expression;
	}
	
	@Override
	public void print() {
		System.out.print("(");
		operator.print();
		expression.print();
		System.out.print(")");
	}

	@Override
	public Types getType() {
		return expression.getType();
	}

	@Override
	public String translate() {
		return "(" + operator.translate(expression.translate()) + ")";
	}

}
