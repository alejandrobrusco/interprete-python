package com.language.types;

public class IndexType extends Types {
	
	public final static String ONLY_INDEX = "ONLY_INDEX";
	public final static String EMPTY_ = "ONLY_INDEX";

	
	Long from;
	Long to;
	Long step;
	Long index;
	
	public IndexType(Long from, Long to, Long step, Long index){
		this.from = from;
		this.to = to;
		this.step = step;
		this.index = index;

	}
	

	@Override
	public TypeEnum getType() {
		return TypeEnum.index_type;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toStringValue() {
		
		return null;
	}


	public Long getFrom() {
		return from;
	}


	public void setFrom(Long from) {
		this.from = from;
	}


	public Long getTo() {
		return to;
	}


	public void setTo(Long to) {
		this.to = to;
	}


	public Long getStep() {
		return step;
	}


	public void setStep(Long step) {
		this.step = step;
	}


	public Long getIndex() {
		return index;
	}


	public void setIndex(Long index) {
		this.index = index;
	}
	
	

}
