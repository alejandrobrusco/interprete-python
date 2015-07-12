package com.language.model.expression;

import java.util.List;
import java.util.Map;

import com.language.model.operators.BinaryOp;
import com.language.types.BooleanType;
import com.language.types.DicType;
import com.language.types.FloatType;
import com.language.types.IntegerType;
import com.language.types.ListType;
import com.language.types.LongType;
import com.language.types.StringType;
import com.language.types.TupleType;
import com.language.types.TypeEnum;
import com.language.types.Types;
import com.language.utils.Values;

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
			if (lType.getType().equals(TypeEnum.string_type) || (rType.getType().equals(TypeEnum.string_type))){
				try {
					return stringEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.string_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if ((lType.getType().equals(TypeEnum.float_type)) || (rType.getType().equals(TypeEnum.float_type))){
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
			else if (lType.getType().equals(TypeEnum.dict_type) || (rType.getType().equals(TypeEnum.dict_type))){
				try {
					return dictEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.dict_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.tuple_type) || (rType.getType().equals(TypeEnum.tuple_type))){
				try {
					return tupleEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.tuple_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.list_type) || (rType.getType().equals(TypeEnum.list_type))){
				try {
					return listEvalArit(lType, operator, rType, lType.getType().equals(TypeEnum.list_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				// [TODO] Excepción de TIPOS
				return null;
			}
			
		} else if (!tipoOperador(operator)) { // Es Lógica
			// Si el operador es OR o AND, no nos interesa conocer de qué tipos son los operandos
			if (operator.equals(BinaryOp.or)){
				return lType;
			}
			else if (operator.equals(BinaryOp.and)){
				return rType;
			}
			
			if (lType.getType().equals(TypeEnum.string_type) || (rType.getType().equals(TypeEnum.string_type))){
				try {
					return stringEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.string_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if ((lType.getType().equals(TypeEnum.float_type)) || (rType.getType().equals(TypeEnum.float_type))){
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
			else if (lType.getType().equals(TypeEnum.dict_type) || (rType.getType().equals(TypeEnum.dict_type))){
				try {
					return dictEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.dict_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.tuple_type) || (rType.getType().equals(TypeEnum.tuple_type))){
				try {
					return tupleEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.tuple_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (lType.getType().equals(TypeEnum.list_type) || (rType.getType().equals(TypeEnum.list_type))){
				try {
					return listEvalLog(lType, operator, rType, lType.getType().equals(TypeEnum.list_type));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				// [TODO] Excepción de TIPOS
				return null;
			}
			
			
		} else {
			// [TODO] Operación no definida
			return null;
		}
		return null;
	}

					
// typeEvalLog
	
	public Types stringEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		Values values = obtenerStringValues(lType,rType,esElPrimero);
		
		String lStringValue = (String) values.getlValue();
		String rStringValue = (String) values.getrValue();
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lStringValue.compareTo(rStringValue) < 0);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lStringValue.compareTo(rStringValue) > 0);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lStringValue.compareTo(rStringValue) <= 0);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lStringValue.compareTo(rStringValue) >= 0);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lStringValue.compareTo(rStringValue) == 0);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lStringValue.compareTo(rStringValue) != 0);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types floatEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{

		Values values = obtenerFloatValues(lType,rType,esElPrimero);
		
		Float lFloatValue = (Float) values.getlValue();
		Float rFloatValue = (Float) values.getrValue();
		
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
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types longEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		Values values = obtenerLongValues(lType,rType,esElPrimero);
		
		Long lLongValue = (Long) values.getlValue();
		Long rLongValue = (Long) values.getrValue();
		
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
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types intEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		Values values = obtenerIntValues(lType,rType,esElPrimero);
		
		Integer lIntValue = (Integer) values.getlValue();
		Integer rIntValue = (Integer) values.getrValue();
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lIntValue < rIntValue);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lIntValue > rIntValue);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lIntValue <= rIntValue);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lIntValue >= rIntValue);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lIntValue == rIntValue);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lIntValue != rIntValue);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types boolEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		Values values = obtenerBoolValues(lType,rType,esElPrimero);
		
		Integer lBoolIntValue = (Integer) values.getlValue();
		Integer rBoolIntValue = (Integer) values.getrValue();
		
		if (operator.equals(BinaryOp.less)){
			return new BooleanType(lBoolIntValue < rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.greater)){
			return new BooleanType(lBoolIntValue > rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.lessOrEqual)){
			return new BooleanType(lBoolIntValue <= rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.greaterOrEqual)){
			return new BooleanType(lBoolIntValue >= rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.equal)){
			return new BooleanType(lBoolIntValue == rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.notEqual)){
			return new BooleanType(lBoolIntValue != rBoolIntValue);
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}	

	public Types dictEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{

		if (operator.equals(BinaryOp.equal)){
			if (lType.getType().equals(TypeEnum.dict_type) && (rType.getType().equals(TypeEnum.dict_type))) {
				Map<Types, Types> lDict = ((DicType) lType).getDic();
				Map<Types, Types> rDict = ((DicType) rType).getDic();
				return new BooleanType(lDict.equals(rDict));
			} else {
				return new BooleanType(false);
			}
		}
		else if (operator.equals(BinaryOp.notEqual)){
			if (lType.getType().equals(TypeEnum.dict_type) && (rType.getType().equals(TypeEnum.dict_type))) {
				Map<Types, Types> lDict = ((DicType) lType).getDic();
				Map<Types, Types> rDict = ((DicType) rType).getDic();
				return new BooleanType(!lDict.equals(rDict));
			} else {
				return new BooleanType(false);
			}
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types tupleEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		if (operator.equals(BinaryOp.equal)){
			if (lType.getType().equals(TypeEnum.tuple_type) && (rType.getType().equals(TypeEnum.tuple_type))) {
				List<Types> lTuple = ((TupleType) lType).getTuple();
				List<Types> rTuple = ((TupleType) rType).getTuple();
				return new BooleanType(lTuple.equals(rTuple));
			} else {
				return new BooleanType(false);
			}
		}
		else if (operator.equals(BinaryOp.notEqual)){
			if (lType.getType().equals(TypeEnum.tuple_type) && (rType.getType().equals(TypeEnum.tuple_type))) {
				List<Types> lTuple = ((TupleType) lType).getTuple();
				List<Types> rTuple = ((TupleType) rType).getTuple();
				return new BooleanType(!lTuple.equals(rTuple));
			} else {
				return new BooleanType(false);
			}
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
	
	public Types listEvalLog(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		if (operator.equals(BinaryOp.equal)){
			if (lType.getType().equals(TypeEnum.list_type) && (rType.getType().equals(TypeEnum.list_type))) {
				List<Types> lList = ((ListType) lType).getList();
				List<Types> rList = ((ListType) rType).getList();
				return new BooleanType(lList.equals(rList));
			} else {
				return new BooleanType(false);
			}
		}
		else if (operator.equals(BinaryOp.notEqual)){
			if (lType.getType().equals(TypeEnum.list_type) && (rType.getType().equals(TypeEnum.list_type))) {
				List<Types> lList = ((ListType) lType).getList();
				List<Types> rList = ((ListType) rType).getList();
				return new BooleanType(!lList.equals(rList));
			} else {
				return new BooleanType(false);
			}
		}
		else{
			// [TODO] Excepción de TIPOS
			return null;
		}
	}
		
// typeEvalArit
	
	public Types stringEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		// La implementación es un poco distinta a las demás implementaciones de xEvalArit(...) porque es bastante particular este tipo
		if (operator.equals(BinaryOp.add)){
			if (lType.getType().equals(TypeEnum.string_type) && (rType.getType().equals(TypeEnum.string_type))){ // "Hola" + "Chau" = "HolaChau". No es necesario hacer el análogo a este ya que los 2 son StringType y no importa el esElPrimero
				String rS = ((StringType) rType).getString();
				String lS = ((StringType) lType).getString().concat(rS);
				return new StringType(lS);
			} else{
				// [TODO] Excepción de TIPOS
			}				
		}
		else if (operator.equals(BinaryOp.mult)){ // Sólo puede ser una multiplicación de un número por un String.
			String s;
			Long it = 0L;
			Types numericType;
			if (esElPrimero){ // "Hola" * 3 = "HolaHolaHola". Consulto si el lType es el String y por lo tanto, el rType el número
				s = ((StringType) lType).getString();
				numericType = rType;
			} else { // 3 * "Hola" = "HolaHolaHola". Consulto si el rType es el String y por lo tanto, el lType el número
				numericType = lType;
				s = ((StringType) rType).getString();
			}
			if (numericType.getType().equals(TypeEnum.long_type)){
				it = ((LongType) numericType).getLong();
			}
			else if (numericType.getType().equals(TypeEnum.int_type)){
				it = ((IntegerType) numericType).getInteger().longValue();
			}
			else if (numericType.getType().equals(TypeEnum.boolean_type)){
				it = ((BooleanType) numericType).getIntegerValue().longValue();
			} else{
				// [TODO] Excepción de TIPOS
			}
			String aux = "";
			for (long i=0; i< it; i++){
				aux += s;
			}
			return new StringType(aux);
		} else { // Operación inválida
			// [TODO] Excepción de TIPOS
		}
		return null;
	}
	
	public Types floatEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Values values = obtenerFloatValues(lType,rType,esElPrimero);
		
		Float lFloatValue = (Float) values.getlValue();
		Float rFloatValue = (Float) values.getrValue();
		
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
		
		Values values = obtenerLongValues(lType,rType,esElPrimero);

		Long lLongValue = (Long) values.getlValue();
		Long rLongValue = (Long) values.getrValue();
		
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
		}
		else if (operator.equals(BinaryOp.bAnd)){
			return new LongType(lLongValue & rLongValue);
		}
		else if (operator.equals(BinaryOp.bOr)){
			return new LongType(lLongValue | rLongValue);
		}
		else if (operator.equals(BinaryOp.bXor)){
			return new LongType(lLongValue ^ rLongValue);
		}
		else if (operator.equals(BinaryOp.bLShift)){
			return new LongType(lLongValue << rLongValue);
		}
		else if (operator.equals(BinaryOp.bRShift)){
			return new LongType(lLongValue >> rLongValue);
		} else {
			return null;
		}
	}
	
	public Types intEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		Values values = obtenerIntValues(lType,rType,esElPrimero);

		Integer lIntValue = (Integer) values.getlValue();
		Integer rIntValue = (Integer) values.getrValue();
		
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
		}
		else if (operator.equals(BinaryOp.bAnd)){
				return new IntegerType(lIntValue & rIntValue);
		}
		else if (operator.equals(BinaryOp.bOr)){
				return new IntegerType(lIntValue | rIntValue);
		}
		else if (operator.equals(BinaryOp.bXor)){
				return new IntegerType(lIntValue ^ rIntValue);
		}
		else if (operator.equals(BinaryOp.bLShift)){
			return new IntegerType(lIntValue << rIntValue);
		}
		else if (operator.equals(BinaryOp.bRShift)){
			return new IntegerType(lIntValue >> rIntValue);
		} else {
			return null;
		}
	}
	
	public Types boolEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		
		Values values = obtenerBoolValues(lType,rType,esElPrimero);
		
		Integer lBoolIntValue = (Integer) values.getlValue();
		Integer rBoolIntValue = (Integer) values.getrValue();

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
		}
		else if (operator.equals(BinaryOp.bXor)){
			return new IntegerType(lBoolIntValue ^ rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.bLShift)){
			return new IntegerType(lBoolIntValue << rBoolIntValue);
		}
		else if (operator.equals(BinaryOp.bRShift)){
			return new IntegerType(lBoolIntValue >> rBoolIntValue);
		}
		else if ((lType.getType().equals(TypeEnum.boolean_type)) && (rType.getType().equals(TypeEnum.boolean_type))){ // Para las operaciones bAnd y bOr: Ambos operandos deben ser booleanos (porque las otras combinaciones válidas ya fueron verificadas anteriormente) y dan como resultado un booleano. Sino, hay un error de tipos
			if (operator.equals(BinaryOp.bAnd)){
				return new BooleanType(((BooleanType) lType).getBoolean() & ((BooleanType) rType).getBoolean());
			}
			else if (operator.equals(BinaryOp.bOr)){
				return new BooleanType(((BooleanType) lType).getBoolean() | ((BooleanType) rType).getBoolean());
			} else {
				// [TODO] Excepción de TIPOS
				return null;
			}
		} else { // No hay otros operadores definidos
			return null;
		}
	}

	public Types dictEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		/*
		Integer lBoolIntValue = 0;
		Integer rBoolIntValue = 0;
		
		obtenerBoolValues(lType,rType,lBoolIntValue,rBoolIntValue,esElPrimero);
		*/
		
		// [TODO] Excepción de TIPOS
		return null;
	}
	
	public Types tupleEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		/*
		Integer lBoolIntValue = 0;
		Integer rBoolIntValue = 0;
		
		obtenerBoolValues(lType,rType,lBoolIntValue,rBoolIntValue,esElPrimero);
		*/
		
		if (operator.equals(BinaryOp.add)){
			if (lType.getType().equals(TypeEnum.tuple_type) || (rType.getType().equals(TypeEnum.tuple_type))){
				List<Types> lTuple = ((TupleType) lType).getTuple();
				List<Types> rTuple = ((TupleType) rType).getTuple();
				lTuple.addAll(rTuple);
				return new TupleType(lTuple);
			} else {
				// [TODO] Excepción de TIPOS
				return null;
			}
		} else { // No hay otros operadores definidos
			return null;
		}
	}
	
	public Types listEvalArit(Types lType, BinaryOp operator, Types rType, boolean esElPrimero) throws Exception{
		/*
		Integer lBoolIntValue = 0;
		Integer rBoolIntValue = 0;
		
		obtenerBoolValues(lType,rType,lBoolIntValue,rBoolIntValue,esElPrimero);
		*/
		
		if (operator.equals(BinaryOp.add)){
			if (lType.getType().equals(TypeEnum.list_type) || (rType.getType().equals(TypeEnum.list_type))){
				List<Types> lList = ((ListType) lType).getList();
				List<Types> rList = ((ListType) rType).getList();
				lList.addAll(rList);
				return new TupleType(lList);
			} else {
				// [TODO] Excepción de TIPOS
				return null;
			}
		} else { // No hay otros operadores definidos
			return null;
		}
	}
	
// obtenerTypeValues

	private Values obtenerStringValues(Types lType, Types rType,boolean esElPrimero) {
		String lStringValue = "";
		String rStringValue = "";
		if (esElPrimero) {
			lStringValue = ((StringType) lType).getString();
			if (rType.getType().equals(TypeEnum.float_type)){
				rStringValue = ((FloatType)rType).toString(); 
			} else if (rType.getType().equals(TypeEnum.long_type)){
				rStringValue = ((LongType) rType).toString();
			}
			else if (rType.getType().equals(TypeEnum.int_type)){
				rStringValue = ((IntegerType) rType).toString();
			}
			else if (rType.getType().equals(TypeEnum.boolean_type)){
				rStringValue = ((BooleanType) rType).toString();
			} else{
				// [TODO] Excepción de TIPOS
			}
		}
		else {
			if (lType.getType().equals(TypeEnum.float_type)){
				lStringValue = ((FloatType)lType).toString(); 
			} else if (lType.getType().equals(TypeEnum.long_type)){
				lStringValue = ((LongType) lType).toString();
			}
			else if (lType.getType().equals(TypeEnum.int_type)){
				lStringValue = ((IntegerType) lType).toString();
			}
			else if (lType.getType().equals(TypeEnum.boolean_type)){
				lStringValue = ((BooleanType) lType).toString();
			} else{
				// [TODO] Excepción de TIPOS
			}
			rStringValue = ((StringType) rType).getString();
		}
		return new Values(lStringValue, rStringValue);
	}
	
	private Values obtenerFloatValues(Types lType, Types rType, boolean esElPrimero) {
		Float lFloatValue = 0f;
		Float rFloatValue = 0f;
		
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
		return new Values(lFloatValue, rFloatValue);
	}

	private Values obtenerLongValues(Types lType, Types rType, boolean esElPrimero) {
		
		Long lLongValue = 0l;
		Long rLongValue = 0l;
		
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
		return new Values(lLongValue, rLongValue);
	}
	
	private Values obtenerIntValues(Types lType, Types rType,boolean esElPrimero) {
		Integer lIntValue = 0;
		Integer rIntValue = 0;
		
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
		
		return new Values(lIntValue,rIntValue);
	}
	
	private Values obtenerBoolValues(Types lType, Types rType, boolean esElPrimero) {
		
		Integer lBoolIntValue = 0;
		Integer rBoolIntValue = 0;
		
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
		return new Values(lBoolIntValue,rBoolIntValue);
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
