package expressions;

import operators.BinaryOperators;
import types.Types;

public class BinaryExpression implements Expression {
	
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
	public Object eval() {
		return operator.eval(this.expression1.eval(),this.expression2.eval());
	}

}
