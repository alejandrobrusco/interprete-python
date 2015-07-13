package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.exceptions.*;
import com.language.model.*;

%%

%cup
%line
%unicode
%column
%public

%class Scanner

%init{
	this.stack.push(0);
	current_indent = 0;
	yybegin(indent_status);
%init}

%{
	private SymbolFactory sf;

	public Scanner(java.io.InputStream r, SymbolFactory sf) {
		this(r);
		this.sf=sf;
	}

	private Symbol symbol(int type) {
		System.out.println("symbol: " + type + "\n");
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value) {
		System.out.println("symbol: " + type + "\n");
		return new Symbol(type, yyline, yycolumn, value);
	}
	
	private static final int TAB_LENGTH = 4;
	
	Stack<Integer> stack = new Stack<Integer>();
	private int current_indent;
	
%}

%eofval{
	return symbol(sym.EOF);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = [ \f\t]+

Digit					= [0-9]
Integer                 = (0 | [1-9]){Digit}*
Float                   = {Integer}?\.{Digit}*
Long                    = {Integer}[lL]
Letter                  = [a-zA-Z]
Identifier              = ({Letter}|"_") ({Letter} | {Digit} | "_")*

AnyCharacter 			= [^\r\n]
Comment 				= "#" {AnyCharacter}* {LineTerminator}?


%state indent_status
%state normal_status

%%

<normal_status>	{

"+" 				{ return symbol(sym.PLUS, "+"); }
"-" 				{ return symbol(sym.MINUS, "-"); }
"**" 				{ return symbol(sym.POW, "**"); }
"*" 				{ return symbol(sym.MULT, "*"); }
"//" 				{ return symbol(sym.DIV_INT, "//"); }
"/" 				{ return symbol(sym.DIV, "/"); }
"%"					{ return symbol(sym.MOD, "%"); }

"(" 				{ return symbol(sym.LPARAN, "("); }
")" 				{ return symbol(sym.RPARAN, ")"); }

"&" 				{ return symbol(sym.BAND, "&"); }
"|" 				{ return symbol(sym.BOR, "|"); }
"^" 				{ return symbol(sym.BXOR, "^"); }
"~" 				{ return symbol(sym.BNOT, "~"); }
"<<" 				{ return symbol(sym.BLSHIFT, "<<"); }
">>" 				{ return symbol(sym.BRSHIFT, ">>"); }


"True" 				{ return symbol(sym.TRUE, "True"); }
"False" 			{ return symbol(sym.FALSE, "False"); }

"and" 				{ return symbol(sym.AND, "and"); }
"or" 				{ return symbol(sym.OR, "or"); }
"not" 				{ return symbol(sym.NOT, "not"); }

"=="				{ return symbol(sym.EQUAL, "=="); }
"!="				{ return symbol(sym.NOT_EQUAL, "!="); }
"<"					{ return symbol(sym.LESS, "<"); }
">"					{ return symbol(sym.GREATER, ">"); }
"<="				{ return symbol(sym.LESS_OR_EQUAL, "<="); }
">="				{ return symbol(sym.GREATER_OR_EQUAL, ">="); }

"["					{ return symbol(sym.LBRACKET, "["); }
"]"					{ return symbol(sym.RBRACKET, "]"); }

"="					{ return symbol(sym.ASSIGN, "="); }

"{"					{ return symbol(sym.LCURLY, "{"); }
"}"					{ return symbol(sym.RCURLY, "}"); }

":"					{ return symbol(sym.COLON, ":"); }
";"					{ return symbol(sym.SEMI_COLON, ";"); }
","					{ return symbol(sym.COMMA, ","); }
"."					{ return symbol(sym.DOT, "."); }

"print"				{ return symbol(sym.PRINT); }
"type"				{ return symbol(sym.TYPE); }
"if"				{ return symbol(sym.IF); }
"else"				{ return symbol(sym.ELSE); }
"def"				{ return symbol(sym.DEF); }
"for"				{ return symbol(sym.FOR); }
"while"				{ return symbol(sym.WHILE); }
"in"                { return symbol(sym.IN); }

"continue"			{ return symbol(sym.CONTINUE); }
"break"				{ return symbol(sym.BREAK); }
"return"			{ return symbol(sym.RETURN); }

"int"				{ return symbol(sym.INT); }
"float"				{ return symbol(sym.FLOAT); }
"str"				{ return symbol(sym.STR); }
"long"				{ return symbol(sym.LONG); }
"tuple"				{ return symbol(sym.TUPLE); }
"list"				{ return symbol(sym.LIST); }
"dict"				{ return symbol(sym.DICT); }

"raw_input"			{ return symbol(sym.RAW_INPUT); }

\"{3}(.|\n)*?\"{3}		{ return symbol(sym.STRING, yytext()); }
\"([^\"\n]*)\"			{ return symbol(sym.STRING, yytext()); }
'{3}(.|\n)*?'{3}		{ return symbol(sym.STRING, yytext()); }
'([^\'\n]*)'			{ return symbol(sym.STRING, yytext()); } 

{Float}					{return symbol(sym.FLOATATION, yytext()); }
{Integer}				{return symbol(sym.INTEGER, yytext()); }
{Long}					{return symbol(sym.LONGER, yytext()); }
{Identifier}			{return symbol(sym.IDENTIFIER, yytext()); }

{WhiteSpace}        	{ /* ignore */ }

{LineTerminator}		{ 
					      current_indent = 0;	
						  yybegin(indent_status);
						  return symbol(sym.NEWLINE);
						}

<<EOF>>   		  		{
						  yypushback(yylength());
						  yybegin(indent_status);
						  return symbol(sym.NEWLINE);
						}


}

<indent_status>{
" "			   		{	current_indent++; }
"\t"			   	{	current_indent = current_indent + TAB_LENGTH; }
"\f"				{	/*Ignore whitespace*/}
.					{	yypushback(1);
						if(current_indent > stack.peek()){
							stack.push(current_indent);
							yybegin(normal_status);
							return symbol(sym.INDENT);
						}
						else if(current_indent == stack.peek()){
							yybegin(normal_status);
						}
						else{
							int tmp = stack.pop();
							return symbol(sym.DEDENT);
						}
					}

{LineTerminator}	{	
						current_indent = 0;
						return symbol(sym.NEWLINE);
					}

<<EOF>>     		{	if (!stack.isEmpty() && stack.pop()!=0){
							yypushback(yylength());
							return symbol(sym.DEDENT);
						}

					  	return symbol(sym.EOF);
					}
					
}


{Comment}           { /* ignore */ }

. 					{
						throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
					}