package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import com.language.types.IndexType;
import com.language.types.ListType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class TargetExp extends Expression {

	IdentifierExp id;
	Expression expr;
	
	public TargetExp(String id, Expression expr) {
		this.id = new IdentifierExp(id);
		this.expr = expr;
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
				
				long index = Long.parseLong(expressionValue.toStringValue());
				
				if (index>maxIndex){
					// EXCEPTION: out of index
					return null;
				}
				else{
					return list.get(Integer.valueOf(expressionValue.toStringValue()));
				}
			}
			else{
				
				List<Types> retList = new ArrayList<Types>();
				
				/*** SIN VALORES DE STEP ***/
				
				// Sin step (con ini y fin)
				if (indexType.getFrom()!=null && indexType.getTo()!=null && indexType.getStep()==null){
					
					int from = this.transformNegativeIndex(list.size(), indexType.getFrom());
					int to = this.transformNegativeIndex(list.size(), indexType.getTo());

					
					retList = list.subList(from, to);
					return new ListType(retList);
				}
				
				// Sin step (con ini, sin fin)
				if (indexType.getFrom()!=null && indexType.getTo()==null && indexType.getStep()==null){
					
					int from = this.transformNegativeIndex(list.size(), indexType.getFrom());

					retList = list.subList(from, list.size()-1);
					return new ListType(retList);
				}
				
				// Sin step (sin ini, con fin)
				if (indexType.getFrom()==null && indexType.getTo()!=null && indexType.getStep()==null){
					
					int to = this.transformNegativeIndex(list.size(), indexType.getTo());

					retList = list.subList(0, to);
					return new ListType(retList);
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
					
					if (by==0){
						// EXCEPTION: step no puede ser zero
						return null;
					}

					if (by<0){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
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
					
					if (by==0){
						// EXCEPTION: step no puede ser zero
						return null;
					}

					if (by<0){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
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
					
					if (by==0){
						// EXCEPTION: step no puede ser zero
						return null;
					}

					if (by<0){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
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
					
					if (by==0){
						// EXCEPTION: step no puede ser zero
						return null;
					}

					if (by<0){
						retList = new ArrayList<Types>();
					}
					else{
						retList = new ArrayList<Types>();
						for (int i=from;i<to;i=i+by){
							retList.add(list.get(i));
						}
					}
					
					return new ListType(retList);
				}
				
				// EXCEPTION - > no debería ocurrir
				return null;
			}
		}
		else{
			// EXCEPTION: tiene que ser una lista el id
			return null;
		}
	}
	
	private int transformNegativeIndex(int listSize, Long value){
		int integer = Integer.valueOf(String.valueOf(value));
		
		if (integer<0){
			integer = integer + listSize;
		}
		
		return integer;
	}

}
