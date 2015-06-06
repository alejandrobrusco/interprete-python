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
WhiteSpace     = {LineTerminator} | [ \t\f]

digit					= [0-9]
integer                 = 0 | [1-9]{digit}*
float                   = {integer}?\.{digit}*
letter                  = [a-zA-Z]
identifier              = ({letter}|"_") ({letter} | {digit} | "_")*


%%

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


\"\"\"(.|\n)*?\"\"\"	{ return symbol(sym.STRING, yytext()); }
\"([^\"\n]*)\"			{ return symbol(sym.STRING, yytext()); }
'''(.|\n)*?'''			{ return symbol(sym.STRING, yytext()); }
'([^\'\n]*)'			{ return symbol(sym.STRING, yytext()); }


{float}					{return symbol(sym.FLOAT, new Float(yytext()));}
{integer}				{return symbol(sym.INTEGER, new Integer(yytext()));}
{identifier}			{return symbol(sym.IDENTIFIER, new String(yytext()));}


{WhiteSpace}        { /* ignore */ }

. 					{
						throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
					}



