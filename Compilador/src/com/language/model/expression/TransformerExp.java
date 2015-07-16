package com.language.model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.language.exceptions.IlegalArgumentException;
import com.language.exceptions.TypeErrorException;
import com.language.types.DicType;
import com.language.types.FloatType;
import com.language.types.IntegerType;
import com.language.types.ListType;
import com.language.types.LongType;
import com.language.types.StringType;
import com.language.types.TupleType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class TransformerExp extends Expression {
	
	private Expression expr;
	private TypeEnum toType;
	int line;
	private List<Expression> list;
	
	public TransformerExp(Expression expr, TypeEnum toType, int line){
		this.expr = expr;
		this.toType = toType;
		this.line = line;
		this.list = null;
	}
	public TransformerExp(List<Expression> list, TypeEnum toType, int line){
		this.list = list;
		this.expr = null;
		this.toType = toType;
		this.line = line;
	}
	
	@Override
	public Types eval() {
		TypeEnum exprTypeEnum;
		Types exprType;
		if (this.expr != null){
			exprType = expr.eval();
		} else {
			exprType = null;
		}
		switch (toType) {
		case int_type:
			if (exprType == null){
				exprType = new IntegerType(0); 
			}
			exprTypeEnum = exprType.getType();
			if (TypeEnum.int_type.equals(exprTypeEnum)){
				return new IntegerType(Integer.parseInt(exprType.toStringValue()));
			} else if (TypeEnum.long_type.equals(exprTypeEnum)){
				return new IntegerType(Integer.parseInt(exprType.toStringValue()));
			} else if (TypeEnum.float_type.equals(exprTypeEnum)){
				String stringValue = exprType.toStringValue();
				return new IntegerType(Integer.parseInt(stringValue.substring(0,stringValue.indexOf("."))));
			} else if (TypeEnum.string_type.equals(exprTypeEnum)){
				return new IntegerType(Integer.parseInt(exprType.toStringValue()));
			} else {
				//TODO EXCEPTION
				return new IntegerType(999999999);
			}
		case long_type:
			if (exprType == null){
				exprType = new LongType(0L); 
			}
			exprTypeEnum = exprType.getType();
			if (TypeEnum.int_type.equals(exprTypeEnum)){
				return new LongType(Long.parseLong(exprType.toStringValue()));
			} else if (TypeEnum.long_type.equals(exprTypeEnum)){
				return new LongType(Long.parseLong(exprType.toStringValue()));
			} else if (TypeEnum.float_type.equals(exprTypeEnum)){
				String stringValue = exprType.toStringValue();
				return new LongType(Long.parseLong(stringValue.substring(0,stringValue.indexOf("."))));
			} else if (TypeEnum.string_type.equals(exprTypeEnum)){
				return new LongType(Long.parseLong(exprType.toStringValue()));
			} else {
				//TODO EXCEPTION
				return new LongType(999999999L);
			}
		case float_type:
			if (exprType == null){
				exprType = new FloatType(0F); 
			}
			exprTypeEnum = exprType.getType();
			if (TypeEnum.int_type.equals(exprTypeEnum)){
				return new FloatType(Float.parseFloat(exprType.toStringValue()));
			} else if (TypeEnum.long_type.equals(exprTypeEnum)){
				return new FloatType(Float.parseFloat(exprType.toStringValue()));
			} else if (TypeEnum.float_type.equals(exprTypeEnum)){
				return new FloatType(Float.parseFloat(exprType.toStringValue()));
			} else if (TypeEnum.string_type.equals(exprTypeEnum)){
				return new FloatType(Float.parseFloat(exprType.toStringValue()));
			} else {
				//TODO EXCEPTION
				return new FloatType(999999999F);
			}
		case string_type:
			if (exprType == null){
				exprType = new StringType(""); 
			}
			exprTypeEnum = exprType.getType();
			return new StringType(exprType.print());
		case tuple_type:
			if (exprType == null){
				exprType = new TupleType(new ArrayList<Types>()); 
			}
			exprTypeEnum = exprType.getType();
			if (TypeEnum.string_type.equals(exprTypeEnum)){
				String stringValue = exprType.toStringValue();
				if (!stringValue.isEmpty()){
					ArrayList<Types> list = new ArrayList<Types>();
					char[] charArray = stringValue.toCharArray();
					for (char c : charArray) {
						Types t = new StringType(String.valueOf(c));
						list.add(t);
					}
					return new TupleType(list);
				}
				return new ListType();
			} else if (TypeEnum.tuple_type.equals(exprTypeEnum)) {
				return new TupleType(((TupleType)exprType).getTuple());
			} else if (TypeEnum.list_type.equals(exprTypeEnum)) {
				return new TupleType(((ListType)exprType).getList());
			} else if (TypeEnum.dict_type.equals(exprTypeEnum)) {
				Set<Types> dicSet = ((DicType)exprType).getDic().keySet();
				List<Types> list = new ArrayList<Types>();
				list.addAll(dicSet);
				return new TupleType(list);
			} else {
				//TODO EXCEPTION tipo no iterable
				return new TupleType();
			}
		
		case list_type:
			if (exprType == null){
				exprType = new ListType(new ArrayList<Types>()); 
			}
			exprTypeEnum = exprType.getType();
			if (TypeEnum.string_type.equals(exprTypeEnum)){
				String stringValue = exprType.toStringValue();
				if (!stringValue.isEmpty()){
					ArrayList<Types> list = new ArrayList<Types>();
					char[] charArray = stringValue.toCharArray();
					for (char c : charArray) {
						Types t = new StringType(String.valueOf(c));
						list.add(t);
					}
					return new ListType(list);
				}
				return new ListType();
			} else if (TypeEnum.list_type.equals(exprTypeEnum)) {
				return new ListType(((ListType)exprType).getList());
			} else if (TypeEnum.tuple_type.equals(exprTypeEnum)) {
				return new ListType(((TupleType)exprType).getTuple());
			} else if (TypeEnum.dict_type.equals(exprTypeEnum)) {
				Set<Types> dicSet = ((DicType)exprType).getDic().keySet();
				List<Types> list = new ArrayList<Types>();
				list.addAll(dicSet);
				return new ListType(list);
			} else {
				//TODO EXCEPTION tipo no iterable
				return new ListType();
			}
		case dict_type:
			if (list == null){
				if (exprType == null ){
					exprType = new ListType(new ArrayList<Types>());
				}
				exprTypeEnum = exprType.getType();
				if (TypeEnum.list_type.equals(exprTypeEnum)){
					List<Types> list = ((ListType)exprType).getList();
					if (list == null || list.isEmpty()){
						return new DicType();
					}
					Map<Types,Types> map = new HashMap<Types,Types>();
					for (Types types : list) {
						if (TypeEnum.tuple_type.equals(types.getType())){
							List<Types> tuple = ((TupleType)types).getTuple();
							if (tuple.size() == 2){
								Types key = tuple.get(0);
								Types value = tuple.get(1);
								map.put(key, value);
							} else {
								throw new IlegalArgumentException("Error at line " + this.line +": dictionary update sequence element #0 has length "+ tuple.size() +"; 2 is required");
							}
						} else {
							throw new TypeErrorException("Error at line " + this.line +": cannot convert dictionary update sequence element #0 to a sequence");
						}
					}
				} else {
					// TODO EXCEPTION tipo no iterable
					return new DicType();
				}
			} else {
				Map<Types,Types> map = new HashMap<Types,Types>();
				
				for (Expression assigExp : list) {
					Expression keyExp = ((AssignExp)assigExp).getId();
					Expression valueExp = ((AssignExp)assigExp).getExpression();
					Types keyType = keyExp.eval();
					Types valueType = valueExp.eval();
					map.put(keyType, valueType);
				}
				return new DicType(map);
			}
			
		default:
			//TODO EXCEPTION no tendria q llegar aca
			return new DicType();
		}
	}
}
