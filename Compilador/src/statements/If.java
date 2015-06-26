package statements;

import java.util.Iterator;
import java.util.List;

import statements.Statement;
import expressions.Expression;

public class If implements Statement {

	Expression expression;
	List<Statement> statementList;
	
	public If(Expression expression, List<Statement> statementList){
		this.expression = expression;
		this.statementList = statementList;
	}
	
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

	public void eval() {
		if ((boolean) expression.eval()){
			if (statementList != null){
				for (Statement statement : statementList) {
					statement.eval();
				}
			}
		}
	}
	
}
