package com.language.model.expression;

import com.language.model.operators.BinaryOp;
import com.language.types.Types;

public class BinaryExp extends Expression {
	
	Expression expression1;
	BinaryOp operator;
	Expression expression2;
	
	public BinaryExp(Expression expression1, BinaryOp operator, Expression expression2){
		this.expression1 = expression1;
		this.operator = operator;
		this.expression2 = expression2;
	}
	
	@Override
	public Types eval() {
			Types lType = expr.getType();
			Types rType = expr2.getType();
			
			switch (operator) {
			case add:
				return (Integer) expr.eval() + (Integer) expr2.eval();
			case and:
				return expr.eval() && expr2.eval();
			case bAnd:
				return expr.eval() & expr2.eval();
			case bLShift:
				return expr.eval() << expr2.eval();
			case bOr:
				return expr.eval() | expr2.eval();
			case bRShift:
				return expr.eval() >> expr2.eval();
			case bXor:
				return expr.eval() ^ expr2.eval();
			case div:
				return expr.eval() / expr2.eval();
			case divInt:
				break;
			case equal:
				break;
			case greater:
				break;
			case greaterOrEqual:
				break;
			case less:
				break;
			case lessOrEqual:
				break;
			case mod:
				break;
			case mult:
				break;
			case notEqual:
				break;
			case or:
				break;
			case pow:
				break;
			case sub:
				break;
			}
			return null;
		}
}
