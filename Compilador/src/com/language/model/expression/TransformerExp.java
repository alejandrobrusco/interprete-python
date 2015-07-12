package com.language.model.expression;

import com.language.types.IntegerType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class TransformerExp extends Expression {
	
	private Expression expr;
	private TypeEnum toType;
	
	public TransformerExp(Expression expr, TypeEnum toType){
		this.expr = expr;
		this.toType = toType;
	}
	
	@Override
	public Types eval() {
		Types exprType = expr.eval();
		TypeEnum exprTypeEnum = exprType.getType();
		switch (toType) {
		case int_type:
			return new IntegerType(Integer.parseInt(exprType.toStringValue()));
//			if (TypeEnum.int_type.equals(exprTypeEnum)){
//				
//			} else if (TypeEnum.long_type.equals(exprTypeEnum)){
//				
//			} else if (TypeEnum.float_type.equals(exprTypeEnum)){
//				
//			} else if (TypeEnum.string_type.equals(exprTypeEnum)){
//				
//			} else {
//				
//			}
		case long_type:
			break;
		case float_type:
			break;
		case string_type:
			break;
		case tuple_type:
			break;
		case list_type:
			break;
		case dict_type:
			break;
		default:
			//TODO EXCEPTION no tendria q llegar aca
			break;
		}
		return null;
	}
}
