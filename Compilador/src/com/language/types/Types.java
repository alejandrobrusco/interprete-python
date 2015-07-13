package com.language.types;

public abstract class Types {
	public abstract TypeEnum getType();
	public abstract String print();
	public abstract String toStringValue();	
	
	public Boolean toBooleanValue(){
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Types){
			return (this.getType().equals(((Types) obj).getType()) && 
					this.toStringValue().equals(((Types) obj).toStringValue()));
		}
		return false;
	}
	
}
