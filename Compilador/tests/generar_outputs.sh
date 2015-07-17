#!/bin/bash

echo "Introducir la ruta del Compilar.jar"
read JAR_PATH
for i in $(ls *.py); do
	python $i > ${i}_output.txt;
	java -jar ${JAR_PATH} ${i} > ${i}_output_propio.txt;
done
