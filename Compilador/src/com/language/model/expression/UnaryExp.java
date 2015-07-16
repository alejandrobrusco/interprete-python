package com.language.model.expression;

import com.language.exceptions.TypeErrorException;
import com.language.model.operators.UnaryOp;
import com.language.types.BooleanType;
import com.language.types.FloatType;
import com.language.types.IntegerType;
import com.language.types.LongType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class UnaryExp extends Expression {

	UnaryOp operator;
	Expression expression;
	int line;
	
	public UnaryExp(UnaryOp operator, Expression expression, int line){
		this.operator = operator;
		this.expression = expression;
		this.line = line;
	}

	@Override
	public Types eval() {
		
		Types t = expression.eval();
		
		if (t.getType().equals(TypeEnum.float_type)){
			
			Float f = ((FloatType) t).getFloat();

			// Operadores deben ser +, -, not
			if (operator.equals(UnaryOp.add)){
				return t;
			}
			else if (operator.equals(UnaryOp.sub)){
				return new FloatType(-f);
			}
			else if (operator.equals(UnaryOp.not)){
				
				if (f != 0){
					return new BooleanType(Boolean.FALSE);
				}
				else{
					return new BooleanType(Boolean.TRUE);

				}
				
			}
			else{
				throw new TypeErrorException("\nError at line " + this.line +": operator " + "\'" + operator.getPythonOperation() + "\' can not be applied to \'" + t.getType().getPythonType() + "\'");
			}
		}
		else if (t.getType().equals(TypeEnum.long_type)){
			
			Long l = ((LongType) t).getLong();

			// Operadores deben ser +, -, not, bNot
			if (operator.equals(UnaryOp.add)){
				return t;
			}
			else if (operator.equals(UnaryOp.sub)){
				return new LongType(-l);
			}
			else if (operator.equals(UnaryOp.not)){
				
				if (l != 0){
					return new BooleanType(Boolean.FALSE);
				}
				else{
					return new BooleanType(Boolean.TRUE);

				}
				
			}
			else if (operator.equals(UnaryOp.bNot)){
				return new LongType(-(l+1));
			}
			else{
				throw new TypeErrorException("\nError at line " + this.line +": operator " + "\'" + operator.getPythonOperation() + "\' can not be applied to \'" + t.getType().getPythonType() + "\'");

			}
		}
		else if (t.getType().equals(TypeEnum.int_type)){
			
			Integer i = ((IntegerType) t).getInteger();

			// Operadores deben ser +, -, not, bNot
			if (operator.equals(UnaryOp.add)){
				return t;
			}
			else if (operator.equals(UnaryOp.sub)){
				return new IntegerType(-i);
			}
			else if (operator.equals(UnaryOp.not)){
				
				if (i != 0){
					return new BooleanType(Boolean.FALSE);
				}
				else{
					return new BooleanType(Boolean.TRUE);

				}
				
			}
			else if (operator.equals(UnaryOp.bNot)){
				return new IntegerType(-(i+1));
			}
			else{
				throw new TypeErrorException("\nError at line " + this.line +": operator " + "\'" + operator.getPythonOperation() + "\' can not be applied to \'" + t.getType().getPythonType() + "\'");

			}
		}
		else if (t.getType().equals(TypeEnum.boolean_type)){
			
			Boolean b = ((BooleanType) t).getBoolean();
			Integer bValue = ((BooleanType) t).getIntegerValue();

			// Operadores deben ser +, -, not, bNot
			if (operator.equals(UnaryOp.add)){
				return new IntegerType(bValue);
			}
			else if (operator.equals(UnaryOp.sub)){
				return new IntegerType(-bValue);
			}
			else if (operator.equals(UnaryOp.not)){
				return new BooleanType(!b);
				
			}
			else if (operator.equals(UnaryOp.bNot)){
				return new IntegerType(-(bValue+1));
			}
			else{
				throw new TypeErrorException("\nError at line " + this.line +": operator " + "\'" + operator.getPythonOperation() + "\' can not be applied to \'" + t.getType().getPythonType() + "\'");

			}
		}
		else{
			throw new TypeErrorException("\nError at line " + this.line +": unary operator " + "can not be applied to \'" + t.getType().getPythonType() + "\'");

		}
	}

}
