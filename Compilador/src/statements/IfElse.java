package statements;

import java.util.Iterator;
import java.util.List;

import statements.Statement;
import expressions.Expression;

public class IfElse implements Statement {

	Expression expression;
	List<Statement> ifStatementList;
	List<Statement> elseStatementList;
	
	public IfElse(Expression expression, List<Statement> ifStatementList, List<Statement> elseStatementList){
		this.expression = expression;
		this.ifStatementList = ifStatementList;
		this.elseStatementList = elseStatementList;
	}
	
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
		
		System.out.print("else: ");
		System.out.println("<<");
		iterator = this.elseStatementList.iterator();
		while(iterator.hasNext()){
			iterator.next().print();
			System.out.println();
		}
		System.out.print(">>");
	}

	public void eval() {
		if ((boolean) expression.eval()){
			if (ifStatementList != null){
				for (Statement statement : ifStatementList) {
					statement.eval();
				}
			}
		} else {
			if (elseStatementList != null){
				for (Statement statement : elseStatementList) {
					statement.eval();
				}
			}
		}
	}
	
}
