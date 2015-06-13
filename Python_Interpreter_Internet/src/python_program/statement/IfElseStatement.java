package python_program.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import python_program.expression.Expression;

public class IfElseStatement extends Statement {
	
	Expression expression;
	List<Statement> ifStatementList;
	List<Statement> elseStatementList;
	
	public IfElseStatement(Expression expression, List<Statement> ifStatementList, List<Statement> elseStatementList){
		this.expression = expression;
		this.ifStatementList = ifStatementList;
		this.elseStatementList = elseStatementList;
	}
	
	@Override
	public void print() {
		System.out.print("if ");
		this.expression.print();
		System.out.println(":");
		
		System.out.println("<<");
		Iterator<Statement> iterator = this.ifStatementList.iterator();
		while(iterator.hasNext()){
			iterator.next().print();
			System.out.println();
		}
		System.out.println(">>");
		
		System.out.println("else:");
		System.out.println("<<");
		iterator = this.elseStatementList.iterator();
		while(iterator.hasNext()){
			iterator.next().print();
			System.out.println();
		}
		System.out.print(">>");
	}

	@Override
	public List<String> translate() {
		String toEval = "(cond (" + expression.translate();
		
		Iterator<Statement> iterator = this.ifStatementList.iterator();
		while(iterator.hasNext()) {
			Iterator<String> stringIterator = iterator.next().translate().iterator();
			while(stringIterator.hasNext()) {
				toEval = toEval + " " + stringIterator.next();
			}
		}
		toEval = toEval + ")(t ";
		Iterator<Statement> iterator2 = this.elseStatementList.iterator();
		while(iterator2.hasNext()) {
			Iterator<String> stringIterator = iterator2.next().translate().iterator();
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
