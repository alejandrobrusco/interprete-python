package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.MessageContext.Scope;

import com.language.model.statements.FunctionDefinitionStm;
import com.language.model.statements.Statement;
import com.language.model.statements.Type;
import com.language.stack.Stack;
import com.language.stack.StackHandler;
import com.language.types.BreakType;
import com.language.types.ContinueType;
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
				stackHandler.setContextReturn(true);
				List<Statement> statemensList = function.getStatemensList();
				Types ret;
				for (Statement statement : statemensList) {
					ret = statement.eval();
					if (ret instanceof ReturnType ){
						break;
					}
				}
				
				stackHandler.setContextReturn(false);
				stack.closeScope();
				
				if (ret instanceof ReturnType){
					ret = ((ReturnType) ret).getValueType();
				}
				
				return ret;
			}
		}else{
			
		}
		
	}

}
