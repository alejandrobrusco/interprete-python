package python_program.statement;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FunctionDefinitionStatement extends Statement {
	
	String identifier;
	List<String> identifierList;
	List<Statement> statementList;
	
	public FunctionDefinitionStatement(String identifier, List<String> identifierList, List<Statement> statementList) {
		this.identifier = identifier;
		Collections.reverse(identifierList);
		this.identifierList = identifierList;
		this.statementList = statementList;
	}
	
	@Override
	public void print() {
		System.out.print("def ");
		System.out.print(this.identifier);
		System.out.print(" (");
		Iterator<String> identifierIterator = identifierList.iterator();
		if(identifierIterator.hasNext()) {
			System.out.print(identifierIterator.next());
		}
		while(identifierIterator.hasNext()) {
			System.out.print(", ");
			System.out.print(identifierIterator.next());
		}
		System.out.println("):");
		
		System.out.println("<<");
		Iterator<Statement> statementIterator = this.statementList.iterator();
		while(statementIterator.hasNext()){
			statementIterator.next().print();
			System.out.println();
		}
		System.out.print(">>");
	}

	@Override
	public List<String> translate() {
		List<String> list = new LinkedList<String>();
		String s = "(defun " + this.identifier + "(";
		Iterator<String> identifierIterator = this.identifierList.iterator();
		while(identifierIterator.hasNext()){
			s = s + " " + identifierIterator.next();
		}
		s = s+ ") ";
		
		Iterator<Statement> stmtIterator = this.statementList.iterator();
		while(stmtIterator.hasNext()){
			Iterator<String> stringIterator = stmtIterator.next().translate().iterator();
			while(stringIterator.hasNext()) {
				s = s + stringIterator.next();
			}
		}
		s = s + ")";
		list.add(s);
		return list;
	}
}
