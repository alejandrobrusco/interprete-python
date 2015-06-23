package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.exceptions.*;
import com.language.model.expression.*;

%%

%cup
%line
%unicode
%column

%class Scanner

%init{
	this.stack.push(0);
	current_indent = 0;
	yybegin(indent_state);
%init}

%{
	private SymbolFactory sf;
	private StringBuffer string = new StringBuffer();

	public Scanner(java.io.InputStream r, SymbolFactory sf) {
		this(r);
		this.sf=sf;
	}

	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value) {
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
WhiteSpace     = {LineTerminator} | [ \f]+

Digit					= [0-9]
Integer                 = 0 | [1-9]{Digit}*
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

"(" 				{ return symbol(sym.LPAREN, "("); }
")" 				{ return symbol(sym.RPAREN, ")"); }

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

"print"				{ return symbol(sym.PRINT); }
"type"				{ return symbol(sym.TYPE); }
"if"				{ return symbol(sym.IF); }
"else"				{ return symbol(sym.ELSE); }
"def"				{ return symbol(sym.DEF); }
"for"				{ return symbol(sym.FOR); }
"while"				{ return symbol(sym.WHILE); }

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

/*FUNCIONES PREDEFINIDAS*/
"has_key"			{ return symbol(sym.HAS_KEY); }		
"items"				{ return symbol(sym.ITEMS); }
"keys"				{ return symbol(sym.KEYS); }
"pop"				{ return symbol(sym.POP); }
"values"			{ return symbol(sym.VALUES); }
"count"				{ return symbol(sym.COUNT); }
"find"				{ return symbol(sym.FIND); }
"join"				{ return symbol(sym.JOIN); }
"split"				{ return symbol(sym.SPLIT); }
"replace"			{ return symbol(sym.REPLACE); }
"length"			{ return symbol(sym.LENGTH); }
"append"			{ return symbol(sym.APPEND); }
"extend"			{ return symbol(sym.EXTEND); }
"index"				{ return symbol(sym.INDEX); }
"insert"			{ return symbol(sym.INSERT); }
"size"				{ return symbol(sym.SIZE); }
			
\"{3}(.|\n)*?\"{3}		{ return symbol(sym.STRING, yytext()); }
\"([^\"\n]*)\"			{ return symbol(sym.STRING, yytext()); }
'{3}(.|\n)*?'{3}		{ return symbol(sym.STRING, yytext()); }
'([^\'\n]*)'			{ return symbol(sym.STRING, yytext()); }


{Float}					{return symbol(sym.FLOATATION, new Float(yytext())); }
{Integer}				{return symbol(sym.INTEGER, new Integer(yytext())); }
{Long}					{return symbol(sym.LONGER, new Long(yytext())); }
{Identifier}			{return symbol(sym.IDENTIFIER, new String(yytext())); }

{WhiteSpace}        	{ /* ignore */ }

{LineTerminator}	{ yybegin(indent_status);
					  current_indent = 0;
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
{LineTerminator}	{	if(current_indent > stack.peek()){
							stack.push(current_indent);
							yybegin(normal_status);
							return symbol(sym.INDENT);
						}
						else if(current_indent == stack.peek()){
							yybegin(normal_status);
						}
						else{
							yypushback(1);
							int tmp = stack.pop();
							return symbol(sym.DEDENT);
						}
					}
}


{Comment}               { /* ignore */ }

. 						{
							throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
						}

