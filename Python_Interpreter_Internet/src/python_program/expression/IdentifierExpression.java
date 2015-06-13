package python_program.expression;

import python_program.Types;

public class IdentifierExpression extends Expression {
	
	String identifier;
	
	public IdentifierExpression(String identifier){
		this.identifier = identifier;
	}
	
	@Override
	public void print() {
		System.out.print(this.identifier);
	}

	@Override
	public Types getType() {
		return Types.nondefined_type;
	}
	
	public String getIdentifier() {
		return this.identifier;
	}

	@Override
	public String translate() {
		return identifier;
	}
	
}
