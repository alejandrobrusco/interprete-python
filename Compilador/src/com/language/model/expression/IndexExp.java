package com.language.model.expression;

import com.language.exceptions.TypeErrorException;
import com.language.types.IndexType;
import com.language.types.TypeEnum;
import com.language.types.Types;

public class IndexExp extends Expression {

	Expression eIni;
	Expression eFin;
	Expression eStep;
	Expression simpleIndex;
	int line;

	public IndexExp(Expression eIni, Expression eFin, Expression eStep,int line) {
		this.eIni = eIni;
		this.eFin = eFin;
		this.eStep = eStep;
	}

	public IndexExp(Expression eIni, Expression eFin,int line) {
		this.eIni = eIni;
		this.eFin = eFin;
	}

	public IndexExp(Expression simpleIndex,int line) {
		this.simpleIndex = simpleIndex;
	}

	@Override
	public Types eval() {
		
		if (this.simpleIndex==null && this.eIni==null && this.eFin==null && this.eStep==null){
			// Excpetion (no se si esto puede pasar)
			return null;
		}

		if (this.simpleIndex != null) {
			Types index = this.simpleIndex.eval();

			if (index.getType().equals(TypeEnum.int_type) || index.getType().equals(TypeEnum.long_type)) {
				return new IndexType(null, null, null, Long.valueOf(index.toStringValue()));
			} else {
				// Exception types
				return null;
			}
		} else {
			
			this.checkType(eIni);
			this.checkType(eFin);
			this.checkType(eStep);
			
			Long start = (this.eIni==null) ? null : Long.valueOf(eIni.eval().toStringValue());
			Long end = (this.eFin==null) ? null : Long.valueOf(eFin.eval().toStringValue());
			Long by = (this.eStep==null) ? null : Long.valueOf(eStep.eval().toStringValue());

			// si pasamos el chequeo de tipos
			return new IndexType(start, end, by, null);
		}

	}

	private void checkType(Expression expr) {

		if (!(expr!=null && (expr.eval().getType().equals(TypeEnum.long_type) || expr.eval().getType().equals(TypeEnum.int_type)))){
			throw new TypeErrorException("Error at line " + this.line +": could not convert '" + expr.eval().getType().getPythonType() + "' to " + TypeEnum.long_type.getPythonType());
		}
	
	}
}
