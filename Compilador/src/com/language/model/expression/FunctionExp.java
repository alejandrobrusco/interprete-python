package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.MessageContext.Scope;

import com.language.model.statements.FunctionDefinitionStm;
import com.language.model.statements.Statement;
import com.language.model.statements.Type;
import com.language.stack.Stack;
import com.language.stack.StackHandler;
import com.language.types.Types;

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
				List<Statement> statemensList = function.getStatemensList();
				for (Statement statement : statemensList) {
					Types ret = statement.eval();
					if (ret instanceof ContinueType || ret instanceof BreakType || ret instanceof ReturnType )
				}
			}
		}else{
			
		}
		
	}

}
