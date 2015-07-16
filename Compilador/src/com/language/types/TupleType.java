package com.language.types;

import java.util.ArrayList;
import java.util.List;

import com.language.types.Types;

public class TupleType extends Types {

	List<Types> value;
	
	public TupleType(){
		
	}
	
	public TupleType(List<Types> value){
		this.value = value;
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.tuple_type;
	}
	
	@Override
	public Boolean toBooleanValue(){
		return !this.value.isEmpty();
	}

	@Override
	public String print() {
		String ret = "(";
		if (this.value!=null && !this.value.isEmpty()){
			List<Types> valueClone = new ArrayList<Types>(this.value);
			Types first = valueClone.remove(0);
			
			String valueToPrint = first.print();
			if (first.getType().equals(TypeEnum.string_type)){
				valueToPrint = this.concatCommillas(first.print());
			}
			
			ret = ret.concat(valueToPrint);
			for (Types types : valueClone) {
				
				valueToPrint = types.print();
				if (types.getType().equals(TypeEnum.string_type)){
					valueToPrint = this.concatCommillas(types.print());
				}
				
				ret = ret.concat(", " + valueToPrint);
			}
		}
		ret = ret.concat(")");
		return ret;
	}
	
	private String concatCommillas(String print) {
		return "'" + print + "'";
	}

	public List<Types> getTuple() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return this.value.toString();
	}
	

}
