package python_program.expression;

import java.util.Iterator;
import java.util.List;

import org.armedbear.lisp.Interpreter;

import python_program.Types;

public class ListExpression extends Expression {
	
	List<Expression> list;
	
	public ListExpression(List<Expression> list) {
		this.list = list;
	}
	
	@Override
	public void print() {
		System.out.print("[ ");
		
		Iterator<Expression> iterator = this.list.iterator();
		if(iterator.hasNext()) {
			iterator.next().print();
		}		
		while(iterator.hasNext()) {
			System.out.print(", ");
			iterator.next().print();			
		}
	
		System.out.print(" ]");
	}

	@Override
	public Types getType() {
		return Types.list_type;
	}

	@Override
	public String translate() {
		String list = "'(";

		Iterator<Expression> iterator = this.list.iterator();
		
		while(iterator.hasNext()) {
			Expression next = iterator.next();
			list = list + " " + next.translate();		
		}
		
		list = list + ")";
		
		return list;
	}

}
