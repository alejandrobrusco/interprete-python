package com.language.compilador;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.language.Program;
import com.language.parser.Parser;
import com.language.parser.Scanner;

public class Compilador {

	public static void main(String[] args) {

		if(args.length == 1){
			try {
				Parser parser = new Parser(new Scanner(new FileReader(args[0])));
				Object value = parser.debug_parse().value;
				Program program = (Program)value;
				program.eval();
				
			} catch (FileNotFoundException e) {
				System.err.println("Error: Can't open file " + args[0]);
				System.exit(-1);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
		else {
			System.out.println("Error: use compilador <filePath>");
			System.exit(-1);
		}
	}

}
