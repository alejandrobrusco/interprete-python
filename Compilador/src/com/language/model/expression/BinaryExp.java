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
		
		if (tipoOperador(operator)) {// Es Aritmética o Bitwise
			if ((lType.getType().equals(TypeEnum.float_type)) || (rType.getType().equals(TypeEnum.float_type))){
				try {
					return floatEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.float_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.long_type) || (rType.getType().equals(TypeEnum.long_type))){
				try {
					return longEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.long_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.int_type) || (rType.getType().equals(TypeEnum.int_type))){
				try {
					return intEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.int_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.boolean_type) || (rType.getType().equals(TypeEnum.boolean_type))){
				try {
					return boolEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.boolean_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// FALTA MUCHO: Long, Int, Boolean, String, List, Dict
		} else if (!tipoOperador(operator)) {
			if ((lType.getType().equals(TypeEnum.float_type)) || (rType.getType().equals(TypeEnum.float_type))){
				try {
					return floatEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.float_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.long_type) || (rType.getType().equals(TypeEnum.long_type))){
				try {
					return longEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.long_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.int_type) || (rType.getType().equals(TypeEnum.int_type))){
				try {
					return intEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.int_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.boolean_type) || (rType.getType().equals(TypeEnum.boolean_type))){
				try {
					return boolEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.boolean_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// FALTA MUCHO: Long, Int, Boolean, String, List, Dict
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
	
// typeEvalLog
	
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
	
	public Types longEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Long lLongValue = 0l;
		Long rLongValue = 0l;
		
		obtenerLongValues(lType,rType,lLongValue,rLongValue,esElPrimero);
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lLongValue < rLongValue);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lLongValue > rLongValue);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lLongValue <= rLongValue);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lLongValue >= rLongValue);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lLongValue == rLongValue);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lLongValue != rLongValue);
		}
		else if (operator.equals(BinaryOp.or)){
			return new LongType(lLongValue);
		}
		else if (operator.equals(BinaryOp.and)){
			return new LongType(rLongValue);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types longEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Long lLongValue = 0l;
		Long rLongValue = 0l;
		
		obtenerLongValues(lType,rType,lLongValue,rLongValue,esElPrimero);
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lLongValue < rLongValue);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lLongValue > rLongValue);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lLongValue <= rLongValue);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lLongValue >= rLongValue);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lLongValue == rLongValue);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lLongValue != rLongValue);
		}
		else if (operator.equals(BinaryOp.or)){
			return new LongType(lLongValue);
		}
		else if (operator.equals(BinaryOp.and)){
			return new LongType(rLongValue);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types boolEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Integer lBoolValue = 0;
		Integer rBoolValue = 0;
		
		obtenerBoolValues(lType,rType,lBoolValue,rBoolValue,esElPrimero);
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lBoolValue < rBoolValue);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lBoolValue > rBoolValue);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lBoolValue <= rBoolValue);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lBoolValue >= rBoolValue);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lBoolValue == rBoolValue);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lBoolValue != rBoolValue);
		}
		else if (operator.equals(BinaryOp.or)){
			if ((lBoolValue + rBoolValue) > 0)
				return new BooleanType(true);
			else
				return new BooleanType(false);
		}
		else if (operator.equals(BinaryOp.and)){
			if ((lBoolValue * rBoolValue) == 1)
				return new BooleanType(true);
			else
				return new BooleanType(false);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
// typeEvalArit
	
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
			return new FloatType(divisionEnteraFloat(lFloatValue, rFloatValue));
		}
		else if (operator.equals(BinaryOp.mod)){
			return new FloatType(lFloatValue % rFloatValue);
		}
		else if (operator.equals(BinaryOp.pow)){ // HAY RIESGO DE OVERFLOW !!!
			return new FloatType(floatPow(lFloatValue, rFloatValue));
		} else {
			return null;
		}
	}
	
	public Types longEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Long lLongValue = 0l;
		Long rLongValue = 0l;
		
		obtenerLongValues(lType,rType,lLongValue,rLongValue,esElPrimero);
		
		if (operator.equals(BinaryOp.add)){
			return new LongType(lLongValue + rLongValue);
		}
		else if (operator.equals(BinaryOp.sub)) {
			return new LongType(lLongValue - rLongValue);
		}
		else if (operator.equals(BinaryOp.mult)){
			return new LongType(lLongValue * rLongValue);
		}
		else if (operator.equals(BinaryOp.div)){
			return new LongType(lLongValue / rLongValue);
		}
		else if (operator.equals(BinaryOp.divInt)){
			return new LongType(divisionEnteraLong(lLongValue, rLongValue));
		}
		else if (operator.equals(BinaryOp.mod)){
			return new LongType(lLongValue % rLongValue);
		}
		else if (operator.equals(BinaryOp.pow)){ // HAY RIESGO DE OVERFLOW !!!
			return new LongType(longPow(lLongValue, rLongValue));
		} else {
			return null;
		}
	}
	
	public Types intEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Integer lIntValue = 0;
		Integer rIntValue = 0;
		
		obtenerIntValues(lType,rType,lIntValue,rIntValue,esElPrimero);
		
		if (operator.equals(BinaryOp.add)){
			return new IntegerType(lIntValue + rIntValue);
		}
		else if (operator.equals(BinaryOp.sub)) {
			return new IntegerType(lIntValue - rIntValue);
		}
		else if (operator.equals(BinaryOp.mult)){
			return new IntegerType(lIntValue * rIntValue);
		}
		else if (operator.equals(BinaryOp.div)){
			return new IntegerType(lIntValue / rIntValue);
		}
		else if (operator.equals(BinaryOp.divInt)){
			return new IntegerType(divisionEnteraInt(lIntValue, rIntValue));
		}
		else if (operator.equals(BinaryOp.mod)){
			return new IntegerType(lIntValue % rIntValue);
		}
		else if (operator.equals(BinaryOp.pow)){ // HAY RIESGO DE OVERFLOW !!!
			return new IntegerType(intPow(lIntValue, rIntValue));
		} else {
			return null;
		}
	}
	
	public Types boolEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Integer lBoolIntValue = 0;
		Integer rBoolIntValue = 0;
		
		obtenerBoolValues(lType,rType,lBoolIntValue,rBoolIntValue,esElPrimero);
		
		if (operator.equals(BinaryOp.add)){
			return new IntegerType(lBoolIntValue + rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.sub)) {
			return new IntegerType(lBoolIntValue - rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.mult)){
			return new IntegerType(lBoolIntValue * rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.div)){
			return new IntegerType(lBoolIntValue / rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.divInt)){
			return new IntegerType(divisionEnteraInt(lBoolIntValue, rBoolIntValue));
		}
		else if (operator.equals(BinaryOp.mod)){
			return new IntegerType(lBoolIntValue % rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.pow)){ // HAY RIESGO DE OVERFLOW !!!
			return new IntegerType(intPow(lBoolIntValue, rBoolIntValue));
		} else {
			return null;
		}
	}

// obtenerTypeValues

	private void obtenerFloatValues(Types lType, Types rType, Float lFloatValue, Float rFloatValue, boolean esElPrimero) {
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

	private void obtenerLongValues(Types lType, Types rType, Long lLongValue, Long rLongValue, boolean esElPrimero) {
		if (esElPrimero) {
			lLongValue = ((LongType) lType).getLong();
			if (rType.getType().equals(TypeEnum.long_type)){
				rLongValue = ((LongType) rType).getLong().longValue();
			}
			else if (rType.getType().equals(TypeEnum.int_type)){
				rLongValue = ((IntegerType) rType).getInteger().longValue();
			}
			else if (rType.getType().equals(TypeEnum.boolean_type)){
				rLongValue = ((BooleanType) rType).getIntegerValue().longValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
		}
		else {
			if (lType.getType().equals(TypeEnum.long_type)){
				lLongValue = ((LongType) lType).getLong().longValue();
			}
			else if (lType.getType().equals(TypeEnum.int_type)){
				lLongValue = ((IntegerType) lType).getInteger().longValue();
			}
			else if (lType.getType().equals(TypeEnum.boolean_type)){
				lLongValue = ((BooleanType) lType).getIntegerValue().longValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
			rLongValue = ((LongType) rType).getLong();
		}
	}
	
	private void obtenerIntValues(Types lType, Types rType, Integer lIntValue, Integer rIntValue, boolean esElPrimero) {
		if (esElPrimero) {
			lIntValue = ((IntegerType) lType).getInteger();
			if (rType.getType().equals(TypeEnum.int_type)){
				rIntValue = ((IntegerType) rType).getInteger().intValue();
			}
			else if (rType.getType().equals(TypeEnum.boolean_type)){
				rIntValue = ((BooleanType) rType).getIntegerValue().intValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
		}
		else {
			if (lType.getType().equals(TypeEnum.int_type)){
				lIntValue = ((IntegerType) lType).getInteger().intValue();
			}
			else if (lType.getType().equals(TypeEnum.boolean_type)){
				lIntValue = ((BooleanType) lType).getIntegerValue().intValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
			rIntValue = ((IntegerType) rType).getInteger();
		}
	}
	
	private void obtenerBoolValues(Types lType, Types rType, Integer lBoolIntValue, Integer rBoolIntValue, boolean esElPrimero) {
		if (esElPrimero) {
			lBoolIntValue = ((BooleanType) lType).getIntegerValue();
			if (rType.getType().equals(TypeEnum.boolean_type)){
				rBoolIntValue = ((BooleanType) rType).getIntegerValue().intValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
		}
		else {
			if (lType.getType().equals(TypeEnum.boolean_type)){
				lBoolIntValue = ((BooleanType) lType).getIntegerValue().intValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
			rBoolIntValue = ((BooleanType) rType).getIntegerValue();
		}
	}
	
// divisionEnteraType
	
	private float divisionEnteraFloat(float dividendo, float divisor){
		float mod = dividendo % divisor;
		return (dividendo - mod) / divisor;
	}

	private long divisionEnteraLong(long dividendo, long divisor){
		long mod = dividendo % divisor;
		return (dividendo - mod) / divisor;
	}
	
	private Integer divisionEnteraInt(Integer dividendo, Integer divisor){
		Integer mod = dividendo % divisor;
		return (dividendo - mod) / divisor;
	}
	
// typePow
	
	private float floatPow(float x, float p) {
	    double doubleResult = Math.pow(x, p);
	    float floatResult = (float) doubleResult; // HAY RIESGO OVERFLOW !!!!!! 
	    return floatResult;
	}
	
	private long longPow(long x, long p) {
	    double doubleResult = Math.pow(x, p);
	    long longResult = (long) doubleResult; // HAY RIESGO OVERFLOW !!!!!! 
	    return longResult;
	}
	
	private int intPow(Integer x, Integer p) {
	    double doubleResult = Math.pow(x, p);
	    int longResult = (int) doubleResult; // HAY RIESGO OVERFLOW !!!!!! 
	    return longResult;
	}
	
// tipoOperador
	
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
