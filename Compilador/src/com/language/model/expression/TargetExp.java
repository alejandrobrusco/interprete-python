package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.language.exceptions.IlegalArgumentException;
import com.language.exceptions.OutOfBoundException;
import com.language.exceptions.TypeErrorException;
import com.language.types.DicType;
import com.language.types.IndexType;
import com.language.types.ListType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class TargetExp extends Expression {

	IdentifierExp id;
	Expression expr;
	int line;
	
	public TargetExp(String id, Expression expr, int line) {
		this.id = new IdentifierExp(id,line);
		this.expr = expr;
		this.line = line;
	}


	@Override
	public Types eval() {
		
		Types variableValue = this.id.eval();
		Types expressionValue = this.expr.eval();
		
		if (variableValue.getType().equals(TypeEnum.list_type) && expressionValue.getType().equals(TypeEnum.index_type)){
			
			IndexType indexType = (IndexType) expressionValue;
			ListType listType = (ListType) variableValue;
			List<Types> list = listType.getList();

			
			if (indexType.getIndex()!=null){
			
				long maxIndex = list.size() -1;
				int index = this.transformNegativeIndex(list.size(), Long.parseLong(expressionValue.toStringValue()));
				
				if (index>maxIndex){
					throw new OutOfBoundException("Error at line " + this.line +": index " + index + " is out of Bound of List called \'" + this.id.getId() + "\'");

				}
				else{
					return list.get(index);
				}
			}
			else{
				
				List<Types> retList = new ArrayList<Types>();
				boolean returnEmptyList = false;
				boolean returnOriginalList = false;

				
				/*** SIN VALORES DE STEP ***/
				
				// Sin step (con ini y fin)
				if (indexType.getFrom()!=null && indexType.getTo()!=null && indexType.getStep()==null){
					
					int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
					int to = this.transformNegativeIndex(list.size(), indexType.getTo());

					returnEmptyList = this.returnEmptyList(from, to);
					returnOriginalList = this.returnOriginalList(list.size(), from, to);
					
					if (!returnEmptyList){
						if (returnOriginalList){
							return new ListType(list);
						}
						else{
							retList = list.subList(from, to);
							return new ListType(retList);
						}
					}
				}
				
				// Sin step (con ini, sin fin)
				if (indexType.getFrom()!=null && indexType.getTo()==null && indexType.getStep()==null){
					
					int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
					
					returnEmptyList = this.returnEmptyList(from, list.size()-1);
					returnOriginalList = this.returnOriginalList(list.size(), from, list.size()-1);

					if (!returnEmptyList){
						if (returnOriginalList){
							return new ListType(list);
						}
						else{
							retList = list.subList(from, list.size()-1);
							return new ListType(retList);
						}
					}
				}
				
				// Sin step (sin ini, con fin)
				if (indexType.getFrom()==null && indexType.getTo()!=null && indexType.getStep()==null){
					
					int to = this.transformNegativeIndex(list.size(), indexType.getTo());
					
					returnEmptyList = this.returnEmptyList(0, to);
					returnOriginalList = this.returnOriginalList(list.size(), 0, to);

					if (!returnEmptyList){
						if (returnOriginalList){
							return new ListType(list);
						}
						else{
							retList = list.subList(0, to);
							return new ListType(retList);
						}
					}
				}
				
				// Sin step (sin ini, sin fin)
				if (indexType.getFrom()==null && indexType.getTo()==null && indexType.getStep()==null){
					
					return new ListType(list);
				}
				
				/*** CON VALORES DE STEP ***/

				// Con step (con ini y con fin)
				if (indexType.getFrom()!=null && indexType.getTo()!=null && indexType.getStep()!=null){
					
					int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
					int to = this.transformNegativeIndex(list.size(), indexType.getTo());
					int by = Integer.valueOf(String.valueOf(indexType.getStep()));
					
					returnEmptyList = this.returnEmptyList(from, to);

					
					if (by==0){
						throw new IlegalArgumentException("Error at line " + this.line +": step can not be zero");
					}

					if (by<0 || returnEmptyList){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
							
							if (i>=list.size()){
								break;
							}
							
							retList.add(list.get(i));
						}
					}
					
					return new ListType(retList);
				}
				
				// Con step (con ini y sin fin)
				if (indexType.getFrom()!=null && indexType.getTo()==null && indexType.getStep()!=null){
					
					int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
					int to = list.size() - 1;
					int by = Integer.valueOf(String.valueOf(indexType.getStep()));
					
					returnEmptyList = this.returnEmptyList(from, to);

					
					if (by==0){
						throw new IlegalArgumentException("Error at line " + this.line +": step can not be zero");
					}

					if (by<0 || returnEmptyList){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
							
							if (i>=list.size()){
								break;
							}
							
							retList.add(list.get(i));
						}
					}
					
					return new ListType(retList);
				}
				
				// Con step (sin ini y con fin)
				if (indexType.getFrom()==null && indexType.getTo()!=null && indexType.getStep()!=null){
					
					int to = this.transformNegativeIndex(list.size(), indexType.getTo());
					int from = 0;
					int by = Integer.valueOf(String.valueOf(indexType.getStep()));
					
					returnEmptyList = this.returnEmptyList(from, to);

					
					if (by==0){
						throw new IlegalArgumentException("Error at line " + this.line +": step can not be zero");
					}

					if (by<0 || returnEmptyList){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
							
							if (i>=list.size()){
								break;
							}
							
							retList.add(list.get(i));
						}
					}
					
					return new ListType(retList);
				}
				
				// Con step (sin ini y sin fin)
				if (indexType.getFrom()==null && indexType.getTo()==null && indexType.getStep()!=null){
					
					int to = list.size()-1;
					int from = 0;
					int by = Integer.valueOf(String.valueOf(indexType.getStep()));
					
					returnEmptyList = this.returnEmptyList(from, to);

					if (by==0){
						throw new IlegalArgumentException("Error at line " + this.line +": step can not be zero");
					}

					if (by<0 || returnEmptyList){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
							
							if (i>=list.size()){
								break;
							}
							
							retList.add(list.get(i));
						}
					}
					
					return new ListType(retList);
				}
				
				return null;
			}
		}
		else{
			throw new TypeErrorException("Error at line " + this.line +": variable \'" + this.id.getId() + "\' isn\'t of type \'list\' or \'dict\'");
		}
	}
	
	private boolean returnOriginalList(int size, int from, int to) {
		
		return (to>=size-1 && from==0);
		
	}

	private boolean checkInterval(int from,int to){
		
		return from>to || from<0 || to<0;
	}

	private boolean returnEmptyList(int from, int to) {
		
		return from>=to;
	}


	private int transformNegativeIndex(int listSize, Long value){
		int integer = Integer.valueOf(String.valueOf(value));
		
		if (integer<0){
			integer = integer + listSize;
		}
		
		return integer;
	}
	
	// Cuando usamos esto para asiganr variables
	public void assign(Expression valueToAssing){
		
		Types variableValue = this.id.eval();
		Types expressionValue = this.expr.eval();
		
		if (variableValue.getType().equals(TypeEnum.list_type) && expressionValue.getType().equals(TypeEnum.index_type)){
			
			IndexType indexType = (IndexType) expressionValue;
			ListType listType = (ListType) variableValue;
			List<Types> list = listType.getList();
			
			if (indexType.getIndex()!=null){
				
				long maxIndex = list.size() -1;
				int index = this.transformNegativeIndex(list.size(), Long.parseLong(expressionValue.toStringValue()));
				
				if (index>maxIndex){
					throw new OutOfBoundException("Error at line " + this.line +": index " + index + " is out of Bound of List called \'" + this.id.getId() + "\'");
				}
				else{
					list.add(index, valueToAssing.eval());
					listType.setList(list);
				}
			}
			else{
				
				// Aca va el tema de que venga con un paso sobre los inidces (controlar que se asigna una lista)
				
				if (valueToAssing.eval().getType().equals(TypeEnum.list_type)){
					
					List<Types> subListToAdd = ((ListType)valueToAssing.eval()).getList();
					
					boolean returnOriginalList = false;
					
					/*** SIN VALORES DE STEP ***/
					
					// Sin step (con ini y fin)
					if (indexType.getFrom()!=null && indexType.getTo()!=null && indexType.getStep()==null){
						
						int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
						int to = this.transformNegativeIndex(list.size(), indexType.getTo());
						
						if (this.checkInterval(from, to)){
							throw new IlegalArgumentException("Error at line " + this.line +": start index can not be greater than end index (" + from +" > "+ to + ")");
						}
						else{
							returnOriginalList = this.returnOriginalList(list.size(), from, to);
							if (returnOriginalList){
								list = subListToAdd;
							}
							else{
								// armo dos listas
								List<Types> firstPart = new ArrayList<Types>();
								List<Types> secondPart = new ArrayList<Types>();
								
								for (int i=0;i<from;i++){
									firstPart.add(list.get(i));
								}
								
								for (int i=to;i<(list.size()-1);i++){
									secondPart.add(list.get(i));
								}
								
								firstPart.addAll(subListToAdd);
								firstPart.addAll(secondPart);

								list = new ArrayList<>(firstPart);
								listType.setList(list);
							}
						}
					}
					
					// Sin step (con ini, sin fin)
					else if (indexType.getFrom()!=null && indexType.getTo()==null && indexType.getStep()==null){
						
						int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
						int to = list.size();
						
						if (this.checkInterval(from, to)){
							throw new IlegalArgumentException("Error at line " + this.line +": start index can not be greater than end index (" + from +" > "+ to + ")");
						}
						else{
							returnOriginalList = this.returnOriginalList(list.size(), from, to);
							if (returnOriginalList){
								list = subListToAdd;
							}
							else{
								// armo dos listas
								List<Types> firstPart = new ArrayList<Types>();
								List<Types> secondPart = new ArrayList<Types>();
								
								for (int i=0;i<from;i++){
									firstPart.add(list.get(i));
								}
								
								for (int i=to;i<(list.size()-1);i++){
									secondPart.add(list.get(i));
								}
								
								firstPart.addAll(subListToAdd);
								firstPart.addAll(secondPart);

								list = new ArrayList<>(firstPart);
								listType.setList(list);
							}
						}
					}
					
					// Sin step (sin ini, con fin)
					else if (indexType.getFrom()==null && indexType.getTo()!=null && indexType.getStep()==null){
						
						int from = 0;
						int to = this.transformNegativeIndex(list.size(), indexType.getTo());
						
						if (this.checkInterval(from, to)){
							throw new IlegalArgumentException("Error at line " + this.line +": start index can not be greater than end index (" + from +" > "+ to + ")");
						}
						else{
							returnOriginalList = this.returnOriginalList(list.size(), from, to);
							if (returnOriginalList){
								list = subListToAdd;
							}
							else{
								// armo dos listas
								List<Types> firstPart = new ArrayList<Types>();
								List<Types> secondPart = new ArrayList<Types>();
								
								for (int i=0;i<from;i++){
									firstPart.add(list.get(i));
								}
								
								for (int i=to;i<(list.size()-1);i++){
									secondPart.add(list.get(i));
								}
								
								firstPart.addAll(subListToAdd);
								firstPart.addAll(secondPart);

								list = new ArrayList<>(firstPart);
								listType.setList(list);
							}
						}
					}
					
					// Sin step (sin ini, sin fin)
					else if (indexType.getFrom()==null && indexType.getTo()==null && indexType.getStep()==null){
						
						int from = 0;
						int to = list.size();
						
						if (this.checkInterval(from, to)){
							throw new IlegalArgumentException("Error at line " + this.line +": start index can not be greater than end index (" + from +" > "+ to + ")");
						}
						else{
							returnOriginalList = this.returnOriginalList(list.size(), from, to);
							if (returnOriginalList){
								list = subListToAdd;
							}
							else{
								// armo dos listas
								List<Types> firstPart = new ArrayList<Types>();
								List<Types> secondPart = new ArrayList<Types>();
								
								for (int i=0;i<from;i++){
									firstPart.add(list.get(i));
								}
								
								for (int i=to;i<(list.size()-1);i++){
									secondPart.add(list.get(i));
								}
								
								firstPart.addAll(subListToAdd);
								firstPart.addAll(secondPart);

								list = new ArrayList<>(firstPart);
								listType.setList(list);
							}
						}
					}
					
					else{
						throw new IlegalArgumentException("Error at line " + this.line +": operation not implemented");
					}
					
				}
				else{
					throw new TypeErrorException("Error at line " + this.line +": variable \'" + this.id.getId() + "\' isn\'t of type \'list\'");
					
				}
			}
			
		}
		else if (variableValue.getType().equals(TypeEnum.list_type) && (expressionValue.getType().equals(TypeEnum.int_type) || expressionValue.getType().equals(TypeEnum.long_type) || expressionValue.getType().equals(TypeEnum.float_type) || expressionValue.getType().equals(TypeEnum.string_type) || expressionValue.getType().equals(TypeEnum.boolean_type))){
			
			DicType dicType = (DicType)variableValue;
			
			Map<Types, Types> dic = dicType.getDic();
			
			dic.put(expressionValue, valueToAssing.eval());
			
		}
		else{
			throw new TypeErrorException("Error at line " + this.line +": variable \'" + this.id.getId() + "\' isn\'t of type \'list\' or \'dict\'");
		}
		
	}

}
