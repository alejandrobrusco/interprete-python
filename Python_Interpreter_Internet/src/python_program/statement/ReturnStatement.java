package python_program.statement;

import java.util.LinkedList;
import java.util.List;

import python_program.expression.Expression;

public class ReturnStatement extends Statement {
	
	Expression expr;

	public ReturnStatement(Expression expr) {
		this.expr = expr;
	}

	@Override
	public void print() {
		System.out.print("return ");
		expr.print();
	}

	@Override
	public List<String> translate() {
		List<String> list = new LinkedList<String>();
		list.add(expr.translate());
		return list;
	}

}
