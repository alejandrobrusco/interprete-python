package python_program.statement;

import java.util.LinkedList;
import java.util.List;

public class PassStatement extends Statement {
	
	public PassStatement(){}
	
	@Override
	public void print() {
		System.out.println("pass");
	}

	@Override
	public List<String> translate() {
		return new LinkedList<String>();
	}

}
