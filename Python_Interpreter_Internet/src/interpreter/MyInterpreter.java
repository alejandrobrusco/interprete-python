package interpreter;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.armedbear.lisp.Interpreter;

import python_program.Program;
import parser.LekserLex;
import parser.ParserCup;


public class MyInterpreter {

	public static void main(String args[])
	{
		Interpreter interpreter = Interpreter.createInstance();
		interpreter.eval("(defun {} (pairs) (let ((h (make-hash-table :test 'equal))) (loop for (key value) on pairs by #'cddr do (setf (gethash key h) value)) h))");
		 
		if(args.length == 0){	//Wczytuje z lini polecen nazwe pliku i go interpretuje
			try {
				ParserCup parser = new ParserCup(new LekserLex(new FileReader("//home/abrusco/svn/cardinal/Python_Interpreter/tests/P3/24_lists.py")));
				Program program = (Program)parser.debug_parse().value;
				//program.print();
				program.translate(interpreter);
				
			} catch (FileNotFoundException e) {
				System.err.println("Error: Can't open file " + args[0]);
				System.exit(-1);
			}catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		else if(args.length > 1){
			System.out.println("Error: Too many arguments");
			System.exit(-1);
		}
		else {
			System.out.println("Error:Missing program argument");
			System.exit(-1);
		}
	}
}
