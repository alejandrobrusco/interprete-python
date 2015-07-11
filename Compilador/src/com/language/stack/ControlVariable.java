package com.language.stack;

public class ControlVariable {
	
	private boolean breakContext;
	private boolean continueContext;
	
	public ControlVariable(){
		this.breakContext = false;
		this.continueContext = false;
	}
	
	public boolean isBreakContext() {
		return breakContext;
	}
	
	public void setBreakContext(boolean breakContext) {
		this.breakContext = breakContext;
	}
	
	public boolean isContinueContext() {
		return continueContext;
	}
	
	public void setContinueContext(boolean continueContext) {
		this.continueContext = continueContext;
	}
	
	

}
