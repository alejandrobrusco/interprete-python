package python_program.expression;

import python_program.Types;

public class SubscriptionExpression extends Expression {
	
	Expression expr1;
	Expression expr2;
	
	public SubscriptionExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public void print() {
		expr1.print();
		System.out.print("[ ");
		expr2.print();
		System.out.print("]");
	}

	@Override
	public Types getType() {
		return expr2.getType();
	}

	@Override
	public String translate() {
		if(expr1.getType() == Types.list_type) {
			return "(nth " + expr2.translate() + " " + expr1.translate() + ")";
		}
		else {
			return null;
		}
	}

}
