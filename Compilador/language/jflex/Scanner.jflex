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
%}

%eofval{
    return symbol(sym.EOF);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]+

digit					= [0-9]
integer                 = 0 | [1-9]{digit}*
float                   = {integer}?\.{digit}*
letter                  = [a-zA-Z]
identifier              = ({letter}|"_") ({letter} | {digit} | "_")*

AnyCharacter 			= [^\r\n]
Comment 				= "#" {AnyCharacter}* {LineTerminator}?


%%

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
"False" 				{ return symbol(sym.FALSE, "False"); }

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
"tuple"				{ return symbol(sym.TUPLE); }
"list"				{ return symbol(sym.LIST); }
"dict"				{ return symbol(sym.DICT); }

"raw_input"			{ return symbol(sym.RAW_INPUT); }

//FUNCIONES PREDEFINIDAS


\"{3}(.|\n)*?\"{3}		{ return symbol(sym.STRING, yytext()); }
\"([^\"\n]*)\"			{ return symbol(sym.STRING, yytext()); }
'{3}(.|\n)*?'{3}		{ return symbol(sym.STRING, yytext()); }
'([^\'\n]*)'			{ return symbol(sym.STRING, yytext()); }


{float}					{return symbol(sym.FLOAT, new Float(yytext()));}
{integer}				{return symbol(sym.INTEGER, new Integer(yytext()));}
{identifier}			{return symbol(sym.IDENTIFIER, new String(yytext()));}

{Comment}               { /* ignore */ }

{WhiteSpace}        	{ /* ignore */ }

. 						{
							throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
						}



