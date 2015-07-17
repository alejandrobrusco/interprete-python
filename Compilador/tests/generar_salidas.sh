#!/bin/bash

JAR_PATH="../build/jar/Compilador.jar"
for i in $(ls *.py); do
	python $i > ${i}_output.txt;
	java -jar ${JAR_PATH} ${i} > salidas/${i}_output_propio.txt;
done
