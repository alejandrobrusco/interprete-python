package com.language.model.statements;

import java.util.List;
import java.util.Set;

import com.language.exceptions.TypeErrorException;
import com.language.model.expression.Expression;
import com.language.stack.ControlVariable;
import com.language.stack.StackHandler;
import com.language.types.DicType;
import com.language.types.ListType;
import com.language.types.TupleType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class ForStm extends Statement {

	String id; 
	Expression expression;
	List<Statement> statementList;
	int line;
	
	public ForStm(String id,Expression expression, List<Statement> statementList, int line){
		this.id = id;
		this.expression = expression;
		this.statementList = statementList;
		this.line = line;
	}
	
	@Override
	public Types eval() {
		
		StackHandler handler = StackHandler.getInstance();
		
		handler.openControlScope();
		
		ControlVariable controlVar = handler.getActualScopeControlVariable();
		controlVar.setBreakContext(true);
		controlVar.setContinueContext(true);
		
		Types iteratorOn = expression.eval();
		
		Types t = null;
		
		if (iteratorOn.getType().equals(TypeEnum.list_type)){
			
			ListType listType = (ListType)iteratorOn;
			
			List<Types> list = listType.getList();
			
			for (Types element: list){
				
				handler.getStack().addVariableToActualScope(id, element);
				
				boolean stopForElements = false;

				for (Statement stm : this.statementList){
					
					t = stm.eval();
					
					if (t.equals(TypeEnum.break_type)){
						stopForElements = true;
						break;
					}
					
					if (t.equals(TypeEnum.return_type)){
						stopForElements = true;
						break;
					}
					
					if (t.equals(TypeEnum.continue_type)){
						break;
					}
				}
				
				if (stopForElements){
					break;
				}
				
			}
			
			handler.closeControlScope();
			
			return t;
			
		}
		else if (iteratorOn.getType().equals(TypeEnum.dict_type)){
			
			DicType dictType = (DicType)iteratorOn;
			
			Set<Types> keys = dictType.getDic().keySet();
			
			for (Types element: keys){
				
				handler.getStack().addVariableToActualScope(id, element);
				
				boolean stopForElements = false;

				for (Statement stm : this.statementList){
					
					t = stm.eval();
					
					if (t.equals(TypeEnum.break_type)){
						stopForElements = true;
						break;
					}
					
					if (t.equals(TypeEnum.return_type)){
						stopForElements = true;
						break;
					}
					
					if (t.equals(TypeEnum.continue_type)){
						break;
					}
				}
				
				if (stopForElements){
					break;
				}
				
			}
			
			handler.closeControlScope();

			return t;
			
		}
		else if (iteratorOn.getType().equals(TypeEnum.tuple_type)){
			
			TupleType tupleType = (TupleType)iteratorOn;
			
			List<Types> tupleValues = tupleType.getTuple();
			
			for (Types element: tupleValues){
				
				handler.getStack().addVariableToActualScope(id, element);
				
				boolean stopForElements = false;

				for (Statement stm : this.statementList){
					
					t = stm.eval();
					
					if (t.equals(TypeEnum.break_type)){
						stopForElements = true;
						break;
					}
					
					if (t.equals(TypeEnum.return_type)){
						stopForElements = true;
						break;
					}
					
					if (t.equals(TypeEnum.continue_type)){
						break;
					}
				}
				
				if (stopForElements){
					break;
				}
				
			}
			
			handler.closeControlScope();

			return t;
			
		}
		else{
			throw new TypeErrorException("Error at line " + this.line +": not Iteration type on sentence \'for\'");
		}
	}
	
}
