package python_program.expression;

import interpreter.FunctionsVariables;

import java.util.Iterator;
import java.util.List;

import python_program.Types;

public class FunctionExpression extends Expression {
	
	Expression expr;
	List<Expression> expressionList;
	
	public FunctionExpression(Expression expr, List<Expression> expressionList) {
		this.expr = expr;
		this.expressionList = expressionList;
	}

	@Override
	public void print() {
		expr.print();
		System.out.print("(");
		
		Iterator<Expression> iterator = expressionList.iterator();
		if(iterator.hasNext()) {
			iterator.next().print();
		}
		while(iterator.hasNext()) {
			System.out.print(",");
			iterator.next().print();
		}
		System.out.print(")");
	}

	@Override
	public Types getType() {
		return Types.none_type;
	}

	@Override
	public String translate() {
		String s = null;
		
		if(FunctionsVariables.function.contains(this.expr.translate())) {
			s = "(" + this.expr.translate();
			Iterator<Expression> iterator = this.expressionList.iterator();
			while(iterator.hasNext()) {
				s = s + " " + iterator.next().translate();
			}
			s = s + ")";
		}
		else {
			s = "(funcall " + this.expr.translate();
			Iterator<Expression> iterator = this.expressionList.iterator();
			while(iterator.hasNext()) {
				s = s + " " + iterator.next().translate();
			}
			s = s + ")";
		}
		
		return s;
	}

}
