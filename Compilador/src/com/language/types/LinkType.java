package com.language.types;

import com.language.stack.StackHandler;
import com.language.types.Types;

public class LinkType extends Types {

	String linkedVariable;
	
	public LinkType(String linkedVariable){
		this.linkedVariable = linkedVariable;
	}

	@Override
	public TypeEnum getType() {
		Types findInOtherScopes = StackHandler.getInstance().getStack().findVariable(this.linkedVariable);
		return findInOtherScopes.getType();
	}
	
	@Override
	public Boolean toBooleanValue(){
		Types findInOtherScopes = StackHandler.getInstance().getStack().findVariable(this.linkedVariable);
		return findInOtherScopes.toBooleanValue();
	}

	@Override
	public String print() {
		Types findInOtherScopes = StackHandler.getInstance().getStack().findVariable(this.linkedVariable);
		return findInOtherScopes.print();
	}
	
	public String getLinkedVariable() {
		return this.linkedVariable;
	}

	@Override
	public String toStringValue() {
		Types findInOtherScopes = StackHandler.getInstance().getStack().findVariable(this.linkedVariable);
		return findInOtherScopes.toStringValue();
	}
	

}
