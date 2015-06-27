package com.language.compilador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

import com.language.parser.Parser;
import com.language.parser.Scanner;
import com.language.Program;

public class Compilador {

	public static void main(String[] args) {

		if(args.length == 1){
			try {
				Parser parser = new Parser(new Scanner(new FileReader(args[0])));
				Program program = (Program)parser.debug_parse().value;
				program.eval();
				
			} catch (FileNotFoundException e) {
				System.err.println("Error: Can't open file " + args[0]);
				System.exit(-1);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		else {
			System.out.println("Error: use compilador <filePath>");
			System.exit(-1);
		}
	}

}
