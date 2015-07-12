package com.language.model.expression;

import com.language.types.StringType;
import com.language.types.Types;

public class StringExp extends Expression {

	String value;
	
	public StringExp(String value){
		if (value.startsWith("\"\"\"") || value.startsWith("'''") ){
			value = value.substring(3,value.length()-3);
		}else if (value.startsWith("\"") || value.startsWith("'")){
			value = value.substring(1,value.length()-1);
		}
		
		char[] chars = value.toCharArray();
		int i = 0;
		int length = value.length();
		while (i < value.length()-1){
			if (chars[i+1] == 'n' && chars[i] == '\\'){
				chars[i] = '\n';
				chars[i+1] = '\0';
				length--;
			} else if (chars[i+1] == 't' && chars[i] == '\\'){
				chars[i] = '\t';
				chars[i+1] = '\0';
				length--;
			} else if (chars[i+1] == 'r' && chars[i] == '\\'){
				chars[i] = '\r';
				chars[i+1] = '\0';
				length--;
			} else if (chars[i+1] == 'f' && chars[i] == '\\'){
				chars[i] = '\f';
				chars[i+1] = '\0';
				length--;
			} else if (chars[i+1] == '\\' && chars[i] == '\\'){
				chars[i] = '\\';
				chars[i+1] = '\0';
				length--;
			}
			i++;
		}
		char[] copy = new char[length];
		i = 0;
		for (int j = 0; j <  value.length() ; j++){
			if (chars[j] != '\0'){
				copy[i] = chars[j];
				i++;
			}
		}
		
		value = new String(copy);
		this.value = value;
	}
	
	@Override
	public Types eval() {
		return new StringType(this.value); 
	}

}
