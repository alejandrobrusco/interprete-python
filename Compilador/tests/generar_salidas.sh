#!/bin/bash

JAR_PATH="../build/jar/Compilador.jar"
for i in $(ls test*.py); do
	python $i > salidas/${i}_output.txt;
	java -jar ${JAR_PATH} ${i} > salidas/${i}_output_propio.txt;
done
