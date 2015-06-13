package python_program.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import python_program.expression.Expression;

public class IfStatement extends Statement{
	
	Expression expression;
	List<Statement> statementList;
	public IfStatement(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}
	
	@Override
	public void print() {
		System.out.print("if ");
		this.expression.print();
		System.out.println(":");
		
		System.out.println("<<");
		Iterator<Statement> iterator = this.statementList.iterator();
		while(iterator.hasNext()){
			iterator.next().print();
			System.out.println();
		}
		System.out.print(">>");
	}

	@Override
	public List<String> translate() {
		String toEval = "(cond (" + expression.translate();
		
		Iterator<Statement> iterator = this.statementList.iterator();
		while(iterator.hasNext()) {
			Iterator<String> stringIterator = iterator.next().translate().iterator();
			while(stringIterator.hasNext()) {
				toEval = toEval + " " + stringIterator.next();
			}
		}
		toEval = toEval + "))";
		List<String> list = new LinkedList<String>();
		list.add(toEval);
		return list;
	}
}
