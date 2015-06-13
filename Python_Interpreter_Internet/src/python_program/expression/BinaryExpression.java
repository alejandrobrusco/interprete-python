package python_program.expression;

import python_program.Types;
import python_program.operators.BinaryOperators;

public class BinaryExpression extends Expression {
	
	Expression expression1;
	BinaryOperators operator;
	Expression expression2;
	
	public BinaryExpression(Expression expression1, BinaryOperators operator, Expression expression2){
		this.expression1 = expression1;
		this.operator = operator;
		this.expression2 = expression2;
	}
	
	@Override
	public void print() {
		System.out.print("(");
		expression1.print();
		System.out.print(" ");
		operator.print();
		System.out.print(" ");
		expression2.print();
		System.out.print(")");
	}

	@Override
	public Types getType() {
		return expression1.getType();
	}

	@Override
	public String translate() {
		return operator.translate(this.expression1.translate(), this.expression2.translate(), this.expression1.getType(), this.expression2.getType());
	}

}
