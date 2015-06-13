package python_program.statement;

import java.util.LinkedList;
import java.util.List;

import python_program.expression.Expression;
import python_program.expression.IdentifierExpression;

public class AssignStatement extends Statement {
	
	IdentifierExpression identifier;
	Expression expression;
	
	public AssignStatement(IdentifierExpression identifier, Expression expression){
		this.identifier = identifier;
		this.expression = expression;
	}
	
	@Override
	public void print() {
		this.identifier.print();
		System.out.print(" = ");
		this.expression.print();
	}

	@Override
	public List<String> translate() {
		List<String> list = new LinkedList<String>();
		//slist.add("(defvar " + this.identifier.getIdentifier() + " " + this.expression.translate() + ")");
		list.add("(defparameter " + this.identifier.getIdentifier() + " " + this.expression.translate() + ")");
		return list;
	}

}
