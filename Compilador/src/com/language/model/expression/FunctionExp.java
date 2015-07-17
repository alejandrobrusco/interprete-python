package com.language.model.expression;

import java.util.ArrayList;
import java.util.List;

import com.language.exceptions.IlegalArgumentException;
import com.language.model.statements.FunctionDefinitionStm;
import com.language.model.statements.Statement;
import com.language.stack.Stack;
import com.language.stack.StackHandler;
import com.language.types.LinkType;
import com.language.types.ReturnType;
import com.language.types.TypeEnum;
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
				List<String> paramsHead = new ArrayList<String>();
				
				if (!parametersList.isEmpty() && parametersList.get(0) instanceof AssignExp){
					// Si se pasan parametros de la forma a=1,b=2
					for (Expression assignExp : parametersList) {
						Expression idExp = ((AssignExp) assignExp).getId();
						String id = ((IdentifierExp)idExp).getId();
						if (paramsHead.contains(id)){
							throw new IlegalArgumentException("\nError at line " + this.line + ": keyword " + id + " argument repeated");
						}
						paramsHead.add(id);
						
						Expression expExp = ((AssignExp) assignExp).getExpression();
						Types expType = expExp.eval();
						
						if (expExp instanceof IdentifierExp){
							// si Es referenciado (list,dict,tuple)
							if (expType.getType().equals(TypeEnum.list_type)
									|| expType.getType().equals(TypeEnum.dict_type) || expType.getType().equals(TypeEnum.tuple_type)){
								LinkType link = new LinkType(((IdentifierExp) expExp).getId());
								expType = link;
							} else if (expType instanceof LinkType){
								LinkType link = new LinkType(((LinkType)expType).getLinkedVariable());
								expType = link;
							}
						}
						paramsValues.add(expType);
					}
				} else {
					// si se pasan los parametros sin la cabecera o no hay parametros
					for (Expression parameterExp : parametersList) {
						Types parameterType = parameterExp.eval();
						
						if (parameterExp instanceof IdentifierExp){
							// si Es referenciado (list,dict,tuple)
							if (parameterType.getType().equals(TypeEnum.list_type)
									|| parameterType.getType().equals(TypeEnum.dict_type) || parameterType.getType().equals(TypeEnum.tuple_type)){
								LinkType link = new LinkType(((IdentifierExp) parameterExp).getId());
								parameterType = link;
							} else if (parameterType instanceof LinkType){
								LinkType link = new LinkType(((LinkType)parameterType).getLinkedVariable());
								parameterType = link;
							}
						}
						paramsValues.add(parameterType);
					}
					paramsHead.addAll(definedParameters);
				}

				int index = 0;
				stack.openScope();

				for (Types types : paramsValues) {
					stack.addVariableToActualScope(paramsHead.get(index), types);
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
				throw new IlegalArgumentException("\nError at line " + this.line + ": function must be called with " + definedParameters.size() + " arguments");
			}
		} else {
			throw new IlegalArgumentException("\nError at line " + this.line + ": general error parsin FunctionExp");

		}

	}

}
