package com.language.model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	public TransformerExp(Expression expr, TypeEnum toType){
		this.expr = expr;
		this.toType = toType;
	}
	
	@Override
	public Types eval() {
		TypeEnum exprTypeEnum;
		Types exprType = expr.eval();
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
			if (exprType == null){
				exprType = new ListType(new ArrayList<Types>()); 
			}
			exprTypeEnum = exprType.getType();
			if (TypeEnum.list_type.equals(exprTypeEnum)){
				List<Types> list = ((ListType)exprType).getList();
				if (list == null){
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
							//TODO EXCEPTION (tienen que ser tuplas de 2 elementos)
							return null;
						}
					} else {
						//TODO EXCEPTION (tienen que ser tuplas de 2 elementos)
						return null;
					}
				}
				return new DicType(map);
			} else if(false){
				//TODO FALTA CONSIDERAR ESTO dict(algo=123,otro="asd")
				
			} else {
				// TODO EXCEPTION tipo no iterable
				return new DicType();
			}
			
		default:
			//TODO EXCEPTION no tendria q llegar aca
			break;
		}
		return null;
	}
}
