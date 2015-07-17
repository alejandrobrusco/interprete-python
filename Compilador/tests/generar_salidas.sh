#!/bin/bash

if [ -e salidas/test_and_or.py_output.txt ]; then
	rm salidas/*;
fi

echo ""
echo "Se generaran las salidas de Python y del proyecto propio"
echo ""
JAR_PATH="../build/jar/Compilador.jar"
for i in $(ls test*.py); do
	python $i > salidas/${i}_output.txt;
	java -jar ${JAR_PATH} ${i} > salidas/${i}_output_propio.txt;
done

clear
echo "Pueden haber diferencias entre las salidas de Python y el proyecto propio porque:"
echo "- Los elementos de un diccionario no tienen un orden"
echo "- Errores de redondeo en divisiones y potencias"
echo ""
echo "PRESIONE UNA TECLA PARA REALIZAR EL DIFF ENTRE LAS SALIDAS"
read
for i in $(ls test*.py); do
	clear	
	echo "------------------- DIFF de ${i} -------------------"
	diff salidas/${i}_output*
	echo ""
	echo "--------------------------------------------------------------------"
	echo "PRESIONA UNA TECLA PARA IR AL SIGUIENTE TEST"
	read
done
clear
echo "FIN de tests automaticos!"

echo ""
echo "Los siguientes tests deben realizarse de forma manual porque requieren interaccion con el usuario:"
for i in $(ls manual*.py); do
	echo ${i};
done
echo ""
echo "FIN DEL SCRIPT"
