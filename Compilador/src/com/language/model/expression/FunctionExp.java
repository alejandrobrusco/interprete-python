package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import com.language.exceptions.IlegalArgumentException;
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
	int line;

	public FunctionExp(Expression idExpr, List<Expression> parametersList, int line) {
		this.idExp = idExpr;
		this.parametersList = parametersList;
		this.line = line;
	}

	@Override
	public Types eval() {
		if (idExp instanceof IdentifierExp) {
			String functionId = ((IdentifierExp) idExp).getId();
			StackHandler stackHandler = StackHandler.getInstance();
			FunctionDefinitionStm function = stackHandler.findFunction(functionId,this.line);
			stackHandler.openFunctionScope();
			List<String> definedParameters = function.getParametersList();
			if (definedParameters.size() == this.parametersList.size()) {
				Stack stack = stackHandler.getStack();
				List<Types> paramsValues = new ArrayList<Types>();
				for (Expression parameterExp : parametersList) {
					Types parameterType = parameterExp.eval();
					paramsValues.add(parameterType);
				}

				int index = 0;
				stack.openScope();

				for (Types types : paramsValues) {
					stack.addVariableToActualScope(definedParameters.get(index), types);
					index++;
				}

				stackHandler.openReturnScope();
				List<Statement> statemensList = function.getStatemensList();
				Types ret = null;
				for (Statement statement : statemensList) {
					ret = statement.eval();
					if (ret instanceof ReturnType) {
						break;
					}
				}

				stackHandler.closeReturnScope();
				stack.closeScope();

				if (ret instanceof ReturnType) {
					ret = ((ReturnType) ret).getValueType();
				} else {
					ret = new VoidType();
				}
				stackHandler.closeFunctionScope();
				return ret;
			} else {
				throw new IlegalArgumentException("Error at line " + this.line + ": function must be called with " + definedParameters.size() + " arguments");
			}
		} else {
			throw new IlegalArgumentException("Error at line " + this.line + ": general error parsin FunctionExp");

		}

	}

}
