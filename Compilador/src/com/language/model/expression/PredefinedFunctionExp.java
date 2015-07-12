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

	private final static String HAS_KEY = "has_key";
	private final static String ITEMS = "items";
	private final static String KEYS = "keys";
	private final static String POP = "pop";
	private final static String VALUES = "values";
	
	private final static String COUNT = "count";
	private final static String FIND = "find";
	private final static String JOIN = "join";
	private final static String SPLIT = "split";
	private final static String REPLACE = "replace";
	private final static String LENGTH = "length";
	
	private final static String APPEND = "append";
	private final static String EXTEND = "extend";
	private final static String INDEX = "index";
	private final static String INSERT = "insert";
	private final static String SIZE = "size";
	
	Expression variable;
	Expression predefinedFunction;
	List<Expression> parametersList;
	
	public PredefinedFunctionExp(Expression variable, Expression predefinedFunction,List<Expression> parametersList) {
		this.variable = variable;
		this.predefinedFunction = predefinedFunction;
		this.parametersList = parametersList;
	}

	@Override
	public Types eval() {
		if (variable instanceof IdentifierExp && predefinedFunction instanceof IdentifierExp){
			String variableId = ((IdentifierExp) variable).getId();
			String predefinedId = ((IdentifierExp) predefinedFunction).getId();
			
			StackHandler stackHandler = StackHandler.getInstance();
			Stack stack = stackHandler.getStack();
			Types variableType = stack.findInActualScope(variableId);
			if (variableType == null){
				variableType = stack.findInGlobalScope(variableId);
				if (variableType == null){
					// TODO EXCEPTION
					return new VoidType();
				}
			}
			
			//Nos fijamos que sea la variable de un tipo esperado (Dict,String,List)
			TypeEnum type = variableType.getType();
			
			if (TypeEnum.dict_type.equals(type)){
				switch (predefinedId) {
				case HAS_KEY:
					if (parametersList.size()==1){
						Types key = parametersList.get(0).eval();
						boolean containsKey = ((DicType) variableType).getDic().containsKey(key);
						return new BooleanType(containsKey);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case ITEMS:
					if (parametersList.size()==0){
						Map<Types, Types> dic = ((DicType) variableType).getDic();
						List<Types> list = new ArrayList<Types>();
						List<Types> tuple;
						
						for (Entry<Types, Types> entry : dic.entrySet()) {
							tuple = new ArrayList<Types>();
							tuple.add(entry.getKey());
							tuple.add(entry.getValue());
							
							TupleType tupleType = new TupleType(tuple);
							list.add(tupleType);
						}
						
						return new ListType(list);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case KEYS:
					if (parametersList.size()==0){
						Set<Types> dicSet = ((DicType) variableType).getDic().keySet();
						List<Types> list = new ArrayList<Types>();
						list.addAll(dicSet);
						return new ListType(list);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case POP:
					if (parametersList.size()==1){
						Types key = parametersList.get(0).eval();
						Types value = ((DicType) variableType).getDic().remove(key);
						return value;
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case VALUES:
					if (parametersList.size()==0){
						List<Types> dicValues = (List<Types>) ((DicType) variableType).getDic().values();
						return new ListType(dicValues);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				default:
					//TODO EXCEPTION no es una funcion predefinida para dict
					return new VoidType();
				}
			}
			else if (TypeEnum.string_type.equals(type)){
				switch (predefinedId) {
				case COUNT:
					if (parametersList.size()==1){
						String str = ((StringType)variableType).getString();
						Types subStrType = parametersList.get(0).eval();
						if (TypeEnum.string_type.equals(subStrType.getType())){
							String subStr = ((StringType)subStrType).getString();
							int indexOf = 0;
							int count = 0;
							while (indexOf != -1){
								indexOf = str.indexOf(subStr, 0);
								if (indexOf != -1){
									indexOf = indexOf + subStr.length();
									count++;
								}
							}
							return new IntegerType(count);
						} else {
							//TODO EXCEPTION no es un string
							return new VoidType();
						}
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case FIND:
					if (parametersList.size()==1){
						String str = ((StringType)variableType).getString();
						Types subStrType = parametersList.get(0).eval();
						if (TypeEnum.string_type.equals(subStrType.getType())){
							String subStr = ((StringType)subStrType).getString();
							int indexOf = str.indexOf(subStr);
							return new IntegerType(indexOf);
						} else {
							//TODO EXCEPTION no es un string
							return new VoidType();
						}
						
					} else if (parametersList.size()==2){
						String str = ((StringType)variableType).getString();
						Types subStrType = parametersList.get(0).eval();
						Types startType = parametersList.get(1).eval();
						if (TypeEnum.string_type.equals(subStrType.getType()) && TypeEnum.int_type.equals(startType.getType()) ){
							String subStr = ((StringType)subStrType).getString();
							Integer i = ((IntegerType)startType).getInteger();
							int indexOf = str.indexOf(subStr,i);
							return new IntegerType(indexOf);
						} else  if (TypeEnum.int_type.equals(startType.getType())) {
							//TODO EXCEPTION no es un string
							return new VoidType();
						} else {
							//TODO EXCEPTION no es un integer
							return new VoidType();
						} 
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case JOIN:
					if (parametersList.size()==1){
						String str = ((StringType)variableType).getString();
						Types joinStrType = parametersList.get(0).eval();
						if (TypeEnum.string_type.equals(joinStrType.getType())){
							String joinStr = ((StringType)joinStrType).getString();
							String retStr = String.join(str, joinStr);
							return new StringType(retStr);
						} else {
							//TODO EXCEPTION no es un string
							return new VoidType();
						}
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
					
				case SPLIT:
					if (parametersList.size()==1){
						String str = ((StringType)variableType).getString();
						Types sepStrType = parametersList.get(0).eval();
						if (TypeEnum.string_type.equals(sepStrType.getType())){
							String sepStr = ((StringType)sepStrType).getString();
							String[] strSplit = str.split(sepStr);
							List<Types> strSplitList  = new ArrayList<Types>();
							for (String s : strSplit) {
								Types t = new StringType(s);
								strSplitList .add(t);
							}
							return new ListType(strSplitList);
						} else {
							//TODO EXCEPTION no es un string
							return new VoidType();
						}
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case REPLACE:
					if (parametersList.size()==2){
						String str = ((StringType)variableType).getString();
						Types oldStrType = parametersList.get(0).eval();
						Types newStrType = parametersList.get(1).eval();
						if (TypeEnum.string_type.equals(oldStrType.getType()) && TypeEnum.string_type.equals(newStrType.getType())){
							String oldStr = ((StringType)oldStrType).getString();
							String newStr = ((StringType)newStrType).getString();
							String replaceFirst = str.replaceFirst(oldStr, newStr);
							return new StringType(replaceFirst);
						} else if (TypeEnum.string_type.equals(newStrType.getType())) {
							//TODO EXCEPTION no es un string
							return new VoidType();
						} else {
							//TODO EXCEPTION no es un string
							return new VoidType();
						}
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case LENGTH:
					if (parametersList.size()==0){
						String str = ((StringType)variableType).getString();
						int length = str.length();
						return new IntegerType(length);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				default:
					//TODO EXCEPTION no es una funcion predefinida para string
					return new VoidType();
				}
			}
			else if (TypeEnum.list_type.equals(type)){
				switch (predefinedId) {
				case APPEND:
					if (parametersList.size()==1){
						Types value = parametersList.get(0).eval();
						boolean ret = ((ListType) variableType).getList().add(value);
						return new BooleanType(ret);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case COUNT:
					if (parametersList.size()==1){
						Types value = parametersList.get(0).eval();
						List<Types> list = ((ListType) variableType).getList();
						int count = 0;
						for (Types types : list) {
							if (types.equals(value)){
								count++;
							}
						}
						return new IntegerType(count);
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case EXTEND:
					if (parametersList.size()==1){
						List<Types> list = ((ListType) variableType).getList();
						Types value = parametersList.get(0).eval();
						Collection<Types> elements;
						if (TypeEnum.dict_type.equals(value.getType())){
							elements = ((DicType)value).getDic().keySet();
						}else if (TypeEnum.list_type.equals(value.getType())){
							elements = ((ListType)value).getList();
						}else if (TypeEnum.tuple_type.equals(value.getType())){
							elements = ((TupleType)value).getTuple();
						}else if (TypeEnum.string_type.equals(value.getType())){
							String str = ((StringType)value).getString();
							elements = new ArrayList<Types>();
							for (int i=0;i < str.length();i++){
								StringType strType = new StringType(String.valueOf(str.charAt(i)));
								elements.add(strType);
							}
						}else{
							//TODO EXCEPTION type
							return new VoidType();
						}
						boolean ret = list.addAll(elements);
						return new BooleanType(ret);
						
					} else {
						//TODO EXCEPTION no tiene un parametro
						return new VoidType();
					}
				case INDEX:
					if (parametersList.size()==1){
						List<Types> list = ((ListType) variableType).getList();
						Types value = parametersList.get(0).eval();
						int count = 0;
						int listSize = list.size();
						while (count < listSize){
							if (list.get(count).equals(value)){
								return new IntegerType(count);
							}
							count++;
						}
						
						//TODO EXCEPTION no se encuentra el indice
						return new VoidType();
						
					} else if (parametersList.size()==2){
						List<Types> list = ((ListType) variableType).getList();
						Types value = parametersList.get(0).eval();
						Types start = parametersList.get(1).eval();
						
						if (TypeEnum.int_type.equals(start.getType())){
							Integer startValue = ((IntegerType)start).getInteger();
							int count = startValue > list.size() ? list.size() : startValue;
							int listSize = list.size();
							while (count < listSize){
								if (list.get(count).equals(value)){
									return new IntegerType(count);
								}
								count++;
							}
							
							//TODO EXCEPTION no se encuentra el indice
							return new VoidType();
							
						} else {
							//TODO EXCEPTION start no es tipo integer
							return new VoidType();
						}
					} else if (parametersList.size()==3){
						List<Types> list = ((ListType) variableType).getList();
						Types value = parametersList.get(0).eval();
						Types start = parametersList.get(1).eval();
						Types end = parametersList.get(2).eval();
						
						if (TypeEnum.int_type.equals(start.getType()) && TypeEnum.int_type.equals(end.getType()) ){
							Integer startValue = ((IntegerType)start).getInteger();
							Integer endValue = ((IntegerType)end).getInteger();
							int count = startValue > list.size() ? list.size() : startValue;
							int tope = endValue > list.size() ? list.size() : endValue;
							while (count < tope){
								if (list.get(count).equals(value)){
									return new IntegerType(count);
								}
								count++;
							}
							
							//TODO EXCEPTION no se encuentra el indice
							return new VoidType();
							
						} else if (TypeEnum.int_type.equals(end.getType())) {
							//TODO EXCEPTION start no es tipo integer
							return new VoidType();
						} else {
							//TODO EXCEPTION end  no es tipo integer
							return new VoidType();
						}
					} else {
						//TODO EXCEPTION cantidad de argumentos
						return new VoidType();
					}
				case INSERT:
					if (parametersList.size()==2){
						Types index = parametersList.get(0).eval();
						Types value = parametersList.get(1).eval();
						
						if (TypeEnum.int_type.equals(index.getType())){
							List<Types> list = ((ListType) variableType).getList();
							Integer i = ((IntegerType)index).getInteger();
							list.add(i, value);
							return new VoidType();
						} else {
							//TODO EXCEPTION end  no es tipo integer
							return new VoidType();
						}						
					} else {
						//TODO EXCEPTION cantidad de argumentos
						return new VoidType();
					}
				case POP:
					if (parametersList.size()==1){
						Types index = parametersList.get(0).eval();
					
						if (TypeEnum.int_type.equals(index.getType())){
							List<Types> list = ((ListType) variableType).getList();
							Integer i = ((IntegerType)index).getInteger();
							boolean ret = list.remove(i);
							return new BooleanType(ret);
						} else {
							//TODO EXCEPTION end  no es tipo integer
							return new VoidType();
						}
						
					} else {
						//TODO EXCEPTION cantidad de argumentos
						return new VoidType();
					}						
				case SIZE:
					if (parametersList.size()==0){
						List<Types> list = ((ListType) variableType).getList();
						return new IntegerType(list.size());
					} else {
						//TODO EXCEPTION cantidad de argumentos
						return new VoidType();
					}						
				default:
					//TODO EXCEPTION no es una funcion predefinida para dict
					return new VoidType();
				}
			} else {
				// TODO EXCEPTION type no valido
				return new VoidType();
			}
		}else{
			//TODO EXCEPTION no es un identificador
			return new VoidType();
		}
	}

}
