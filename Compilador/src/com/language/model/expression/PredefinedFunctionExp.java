package com.language.model.expression;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.language.stack.Stack;
import com.language.stack.StackHandler;
import com.language.types.BooleanType;
import com.language.types.DicType;
import com.language.types.IntegerType;
import com.language.types.ListType;
import com.language.types.StringType;
import com.language.types.TupleType;
import com.language.types.TypeEnum;
import com.language.types.Types;
import com.language.types.VoidType;

public class PredefinedFunctionExp extends Expression {

	@Override
	public Types eval() {
		// TODO Auto-generated method stub
		return null;
	}

//	private final static String HAS_KEY = "has_key";
//	private final static String ITEMS = "items";
//	private final static String KEYS = "keys";
//	private final static String POP = "pop";
//	private final static String VALUES = "values";
//	
//	private final static String COUNT = "count";
//	private final static String FIND = "find";
//	private final static String JOIN = "join";
//	private final static String SPLIT = "split";
//	private final static String REPLACE = "replace";
//	private final static String LENGTH = "length";
//	
//	private final static String APPEND = "append";
//	private final static String EXTEND = "extend";
//	private final static String INDEX = "index";
//	private final static String INSERT = "insert";
//	private final static String SIZE = "size";
//	
//	Expression variable;
//	Expression predefinedFunction;
//	List<Expression> parametersList;
//	
//	public PredefinedFunctionExp(Expression variable, Expression predefinedFunction,List<Expression> parametersList) {
//		this.variable = variable;
//		this.predefinedFunction = predefinedFunction;
//		this.parametersList = parametersList;
//	}
//
//	@Override
//	public Types eval() {
//		if (variable instanceof IdentifierExp && predefinedFunction instanceof IdentifierExp){
//			String variableId = ((IdentifierExp) variable).getId();
//			String predefinedId = ((IdentifierExp) predefinedFunction).getId();
//			
//			StackHandler stackHandler = StackHandler.getInstance();
//			Stack stack = stackHandler.getStack();
//			Types variableType = stack.findInActualScope(variableId);
//			if (variableType == null){
//				variableType = stack.findInGlobalScope(variableId);
//				if (variableType == null){
//					// TODO EXCEPTION
//					return new VoidType();
//				}
//			}
//			
//			//Nos fijamos que sea la variable de un tipo esperado (Dict,String,List)
//			TypeEnum type = variableType.getType();
//			
//			if (TypeEnum.dict_type.equals(type)){
//				switch (predefinedId) {
//				case HAS_KEY:
//					if (parametersList.size()==1){
//						Types key = parametersList.get(0).eval();
//						boolean containsKey = ((DicType) variableType).getDic().containsKey(key);
//						return new BooleanType(containsKey);
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case ITEMS:
//					if (parametersList.size()==0){
//						Map<Types, Types> dic = ((DicType) variableType).getDic();
//						List<Types> list = new ArrayList<Types>();
//						List<Types> tuple;
//						
//						for (Entry<Types, Types> entry : dic.entrySet()) {
//							tuple = new ArrayList<Types>();
//							tuple.add(entry.getKey());
//							tuple.add(entry.getValue());
//							
//							TupleType tupleType = new TupleType(tuple);
//							list.add(tupleType);
//						}
//						
//						return new ListType(list);
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case KEYS:
//					if (parametersList.size()==0){
//						Set<Types> dicSet = ((DicType) variableType).getDic().keySet();
//						List<Types> list = new ArrayList<Types>();
//						list.addAll(dicSet);
//						return new ListType(list);
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case POP:
//					if (parametersList.size()==1){
//						Types key = parametersList.get(0).eval();
//						Types value = ((DicType) variableType).getDic().remove(key);
//						return value;
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case VALUES:
//					if (parametersList.size()==0){
//						List<Types> dicValues = (List<Types>) ((DicType) variableType).getDic().values();
//						return new ListType(dicValues);
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				default:
//					//TODO EXCEPTION no es una funcion predefinida para dict
//					break;
//				}
//			}
//			else if (TypeEnum.string_type.equals(type)){
//				switch (predefinedId) {
//				case COUNT:
//					break;
//				case FIND:
//					break;
//				case JOIN:
//					break;
//				case SPLIT:
//					break;
//				case REPLACE:
//					break;
//				case LENGTH:
//					break;
//				default:
//					//TODO EXCEPTION no es una funcion predefinida para dict
//					break;
//				}
//			}
//			else if (TypeEnum.list_type.equals(type)){
//				switch (predefinedId) {
//				case APPEND:
//					if (parametersList.size()==1){
//						Types value = parametersList.get(0).eval();
//						boolean ret = ((ListType) variableType).getList().add(value);
//						return new BooleanType(ret);
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case COUNT:
//					if (parametersList.size()==1){
//						Types value = parametersList.get(0).eval();
//						List<Types> list = ((ListType) variableType).getList();
//						int count = 0;
//						for (Types types : list) {
//							if (types.equals(value)){
//								count++;
//							}
//						}
//						return new IntegerType(count);
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case EXTEND:
//					if (parametersList.size()==1){
//						List<Types> list = ((ListType) variableType).getList();
//						Types value = parametersList.get(0).eval();
//						Collection<Types> elements;
//						if (TypeEnum.dict_type.equals(value.getType())){
//							elements = ((DicType)value).getDic().keySet();
//						}else if (TypeEnum.list_type.equals(value.getType())){
//							elements = ((ListType)value).getList();
//						}else if (TypeEnum.tuple_type.equals(value.getType())){
//							elements = ((TupleType)value).getTuple();
//						}else if (TypeEnum.string_type.equals(value.getType())){
//							String str = ((StringType)value).getString();
//							elements = new ArrayList<Types>();
//							for (int i=0;i < str.length();i++){
//								StringType strType = new StringType(String.valueOf(str.charAt(i)));
//								elements.add(strType);
//							}
//						}else{
//							//TODO EXCEPTION type
//							return new VoidType();
//						}
//						boolean ret = list.addAll(elements);
//						return new BooleanType(ret);
//						
//					} else {
//						//TODO EXCEPTION no tiene un parametro
//						return new VoidType();
//					}
//				case INDEX:
//					break;
//				case INSERT:
//					break;
//				case POP:
//					break;
//				case SIZE:
//					break;
//				default:
//					//TODO EXCEPTION no es una funcion predefinida para dict
//					break;
//				}
//			} else {
//				// TODO EXCEPTION type no valido
//				return new VoidType();
//			}
//		}else{
//			//TODO EXCEPTION no es un identificador
//			return new VoidType();
//		}
//		
//	}

}
