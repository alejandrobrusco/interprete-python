package com.language.model.expression;

import java.util.List;

import com.language.model.statements.FunctionDefinitionStm;
import com.language.model.statements.Statement;
import com.language.stack.Stack;
import com.language.stack.StackHandler;
import com.language.types.ReturnType;
import com.language.types.Types;
import com.language.types.VoidType;

public class FunctionExp extends Expression {

	Expression idExp;
	List<Expression> parametersList;
	
	public FunctionExp(Expression idExpr, List<Expression> parametersList) {
		this.idExp = idExpr;
		this.parametersList = parametersList;
	}

	@Override
	public Types eval() {
		if (idExp instanceof IdentifierExp){
			String functionId = ((IdentifierExp) idExp).getId();
			StackHandler stackHandler = StackHandler.getInstance();
			FunctionDefinitionStm function = stackHandler.findFunction(functionId);
			stackHandler.openFunctionScope();
			List<String> definedParameters = function.getParametersList();
			if (definedParameters.size() == this.parametersList.size()){
				Stack stack = stackHandler.getStack();
				stack.openScope();
				int index = 0;
				for (Expression parameterExp : parametersList) {
					Types parameterType = parameterExp.eval();
					stack.addVariableToActualScope(definedParameters.get(index), parameterType);
					index++;
				}
				stackHandler.openReturnScope();
				List<Statement> statemensList = function.getStatemensList();
				Types ret = null;
				for (Statement statement : statemensList) {
					ret = statement.eval();
					if (ret instanceof ReturnType ){
						break;
					}
				}
				
				stackHandler.closeReturnScope();
				stack.closeScope();
				
				if (ret instanceof ReturnType){
					ret = ((ReturnType) ret).getValueType();
				} else {
					ret = new VoidType();
				}
				stackHandler.closeFunctionScope();
				return ret;
			} else {
				//TODO EXCEPTION cant parametros
				return new VoidType();
			}
		}else{
			//TODO EXCEPTION no es 
			return new VoidType();
		}
		
	}

}
