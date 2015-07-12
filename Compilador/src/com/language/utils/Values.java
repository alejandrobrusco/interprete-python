package com.language.utils;

public class Values {

	private Object lValue;
	private Object rValue;
	

	public Values (Object lValue, Object rValue){
		this.lValue = lValue;
		this.rValue = rValue;
	}
	
	public Object getlValue() {
		return lValue;
	}
	
	public void setlValue(Object lValue) {
		this.lValue = lValue;
	}
	
	public Object getrValue() {
		return rValue;
	}
	
	public void setrValue(Object rValue) {
		this.rValue = rValue;
	}
	
}
