package com.language.model.expression;

import com.language.model.operators.BinaryOp;
import com.language.types.BooleanType;
import com.language.types.FloatType;
import com.language.types.IntegerType;
import com.language.types.LongType;
import com.language.types.TypeEnum;
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
		Types lType = expression1.eval();
		Types rType = expression2.eval();
		
		if (tipoOperador(operator)) {// Es Aritmetica o Bitwise
			if ((lType.getType().equals(TypeEnum.float_type)) || (rType.getType().equals(TypeEnum.float_type))){
				try {
					return floatEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.float_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.long_type)){
				// FALTA MUCHO: Long, Int, Boolean, String, List, Dict
				return null;
			}
		} else if (!tipoOperador(operator)) {
			if ((lType.getType().equals(TypeEnum.float_type)) || (rType.getType().equals(TypeEnum.float_type))){
				try {
					return floatEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.float_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.long_type)){
				// FALTA MUCHO: Long, Int, Boolean, String, List, Dict
				return null;
			}
		} else {
			return null;
		}
		return null;
	}

					
					
		/*
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
			
		/*
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
		return null;*/
	
	
	public Types floatEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Float lFloatValue = 0f;
		Float rFloatValue = 0f;
		
		obtenerFloatValues(lType,rType,lFloatValue,rFloatValue,esElPrimero);
		
		if (operator.equals(BinaryOp.add)){
			return new FloatType(lFloatValue + rFloatValue);
		}
		else if (operator.equals(BinaryOp.sub)) {
			return new FloatType(lFloatValue - rFloatValue);
		}
		else if (operator.equals(BinaryOp.mult)){
			return new FloatType(lFloatValue * rFloatValue);
		}
		else if (operator.equals(BinaryOp.div)){
			return new FloatType(lFloatValue / rFloatValue);
		}
		else if (operator.equals(BinaryOp.divInt)){
			return new FloatType(divisionEntera(lFloatValue, rFloatValue));
		}
		else if (operator.equals(BinaryOp.mod)){
			return new FloatType(lFloatValue % rFloatValue);
		}
		else if (operator.equals(BinaryOp.pow)){ // HAY RIESGO DE OVERFLOW !!!
			return new FloatType(floatPow(lFloatValue, rFloatValue));
		}
		else if (operator.equals(BinaryOp.divInt)){
			return new FloatType(lFloatValue * rFloatValue);
		} else {
			return null;
		}
	}

	public Types floatEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Float lFloatValue = 0f;
		Float rFloatValue = 0f;
		
		obtenerFloatValues(lType,rType,lFloatValue,rFloatValue,esElPrimero);
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lFloatValue < rFloatValue);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lFloatValue > rFloatValue);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lFloatValue <= rFloatValue);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lFloatValue >= rFloatValue);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lFloatValue == rFloatValue);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lFloatValue != rFloatValue);
		}
		else if (operator.equals(BinaryOp.or)){
			return new FloatType(lFloatValue);
		}
		else if (operator.equals(BinaryOp.and)){
			return new FloatType(rFloatValue);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	

	private void obtenerFloatValues(Types lType,Types rType, Float lFloatValue,Float rFloatValue, boolean esElPrimero) {
		if (esElPrimero) {
			lFloatValue = ((FloatType) lType).getFloat();
			if (rType.getType().equals(TypeEnum.float_type)){
				rFloatValue = ((FloatType)rType).getFloat(); 
			} else if (rType.getType().equals(TypeEnum.long_type)){
				rFloatValue = ((LongType) rType).getLong().floatValue();
			}
			else if (rType.getType().equals(TypeEnum.int_type)){
				rFloatValue = ((IntegerType) rType).getInteger().floatValue();
			}
			else if (rType.getType().equals(TypeEnum.boolean_type)){
				rFloatValue = ((BooleanType) rType).getIntegerValue().floatValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
		}
		else {
			if (lType.getType().equals(TypeEnum.float_type)){
				lFloatValue = ((FloatType)lType).getFloat(); 
			} else if (lType.getType().equals(TypeEnum.long_type)){
				lFloatValue = ((LongType) lType).getLong().floatValue();
			}
			else if (lType.getType().equals(TypeEnum.int_type)){
				lFloatValue = ((IntegerType) lType).getInteger().floatValue();
			}
			else if (lType.getType().equals(TypeEnum.boolean_type)){
				lFloatValue = ((BooleanType) lType).getIntegerValue().floatValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
			rFloatValue = ((FloatType) rType).getFloat();
		}
	}
	
	
	private Float divisionEntera(Float dividendo, Float divisor){
		Float mod = dividendo % divisor;
		return (dividendo - mod) / divisor;
	}
	
	private float floatPow(float x, float p) {
	    double doubleResult = Math.pow(x, p);
	    float floatResult = (float) doubleResult; // HAY RIESGO OVERFLOW !!!!!! 
	    return floatResult;
	}
	
	// NO UTILIZADO
	private Boolean tipoOperador(BinaryOp operator){
		if (operator.equals(BinaryOp.add) || 
				operator.equals(BinaryOp.sub) ||
				operator.equals(BinaryOp.mult) || 
				operator.equals(BinaryOp.div) || 
				operator.equals(BinaryOp.divInt) || 
				operator.equals(BinaryOp.mod) || 
				operator.equals(BinaryOp.pow) ||
				operator.equals(BinaryOp.bAnd) || 
				operator.equals(BinaryOp.bOr) || 
				operator.equals(BinaryOp.bXor) ||
				operator.equals(BinaryOp.bLShift) ||
				operator.equals(BinaryOp.bRShift)) {
			return true; // Aritmetica Y Bitwise
		}
		else if (operator.equals(BinaryOp.less) || 
				operator.equals(BinaryOp.greater) ||
				operator.equals(BinaryOp.lessOrEqual) || 
				operator.equals(BinaryOp.greaterOrEqual) || 
				operator.equals(BinaryOp.equal) || 
				operator.equals(BinaryOp.notEqual) ||
				operator.equals(BinaryOp.or) || 
				operator.equals(BinaryOp.and)) {
			return false; // Booleanos
		}
		return null;
	}
}
