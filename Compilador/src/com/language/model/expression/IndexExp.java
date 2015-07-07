package com.language.model.expression;

import com.language.types.Types;

public class IndexExp extends Expression {
	
	Expression eIni;
	Expression eFin;
	Expression eStep;
	
	public IndexExp(Expression eIni, Expression eFin, Expression eStep){
		this.eIni = eIni;
		this.eFin = eFin;
		this.eStep = eStep;
	}
	
	public IndexExp(Expression eIni, Expression eFin){
		this.eIni = eIni;
		this.eFin = eFin;
	}
	
	public IndexExp(Expression eIni){
		this.eIni = eIni;
	}
	
	@Override
	public Types eval() {
		return null;
	}
}
