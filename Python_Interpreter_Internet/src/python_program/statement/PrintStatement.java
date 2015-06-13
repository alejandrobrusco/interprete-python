package python_program.statement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import python_program.expression.Expression;

public class PrintStatement extends Statement {
	
	List<Expression> expressions;
	
	public PrintStatement(List<Expression> expressions){
		this.expressions = expressions;
	}
	
	@Override
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

	@Override
	public List<String> translate() {
		List<String> list = new LinkedList<String>();
		
		Iterator<Expression> iterator = this.expressions.iterator();
		if(iterator.hasNext() == false) {
			list.add("(format t \"~%\")");
		}
		
		while (iterator.hasNext()) {
			list.add("(print " + iterator.next().translate() + ")");
		}
		return list;
	}

}
