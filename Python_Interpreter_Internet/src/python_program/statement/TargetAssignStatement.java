package python_program.statement;

import java.util.LinkedList;
import java.util.List;

import python_program.expression.Expression;

public class TargetAssignStatement extends Statement {
	
	Expression expr1;
	Expression expr2;
	
	public TargetAssignStatement(Expression expr1, Expression expr2) {
		this.expr1= expr1;
		this.expr2 = expr2;
	}

	@Override
	public void print() {
		this.expr1.print();
		System.out.print(" = ");
		this.expr2.print();
	}

	@Override
	public List<String> translate() {
		List<String> list = new LinkedList<String>();

		list.add("(defvar " + this.expr1.translate() + " " + this.expr2.translate() + ")");
		list.add("(setq " + this.expr1.translate() + " " + this.expr2.translate() + ")");
		return list;
	}

}
