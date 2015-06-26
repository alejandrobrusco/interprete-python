package statements;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import expressions.Expression;

public class Print implements Statement {
	
	List<Expression> expressions;
	
	public Print(List<Expression> expressions){
		this.expressions = expressions;
	}
	
	public void print() {
		System.out.print("print ");
		
		Iterator<Expression> iterator = expressions.iterator();
		if(iterator.hasNext()) {
			iterator.next().print();
		}
		while(iterator.hasNext()){
			System.out.print(", ");
			iterator.next().print();
		}
	}

	public void eval() {
		if (expressions != null){
			for (Expression expression : expressions) {
				System.out.print(expression.eval()+" ");
			}
		}
	}
}
