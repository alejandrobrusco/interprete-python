package com.language.types;

import java.util.List;

import com.language.types.Types;

public class TupleType extends Types {

	List<Types> value;
	
	public TupleType(List<Types> value){
		this.value = value;
	}

	@Override
	public TypeEnum getType() {
		return TypeEnum.tuple_type;
	}

	@Override
	public String print() {
		String ret = "(";
		if (!this.value.isEmpty()){
			Types first = this.value.remove(0);
			ret = ret.concat(first.print());
			for (Types types : this.value) {
				ret = ret.concat("," + types.print());
			}
		}
		ret = ret.concat(")");
		return ret;
	}
	
	public List<Types> getTuple() {
		return this.value;
	}

	@Override
	public String toStringValue() {
		return this.value.toString();
	}
	

}
