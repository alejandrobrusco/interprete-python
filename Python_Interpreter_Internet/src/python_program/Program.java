package python_program;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.armedbear.lisp.Interpreter;

import python_program.statement.Statement;

public class Program {
	List<Statement> statements;
	
	public Program(List<Statement> statements){
		this.statements = statements;
	}
	
	public void print(){
		Iterator<Statement> iterator = statements.iterator();
		while(iterator.hasNext()){ 
			iterator.next().print();
			System.out.println();
		}
	}

	public void translate(Interpreter interpreter) {
		List<String> list = new LinkedList<String>();
		Iterator<Statement> iterator = statements.iterator();
		while(iterator.hasNext()){ 
			Statement next = iterator.next();
			list.addAll(next.translate());
		}
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String next = it.next();
			interpreter.eval(next);
		}
		interpreter.eval("(print \" \")");
	}
}
