#!/bin/bash
echo "1 - Compilar (a través de ANT)"
echo "2 - Ejecutar"
echo "Ingrese la opción deseada:"
read opcion
if  [ -z "$opcion" ]; then
        opcion=1
fi

if [ $opcion = 2 ]; then
        clear
	echo "Introduzca la ruta del archivo de entrada (Ejemplo: /home/USER/test.py):"
	read FILEPATH
	echo
	clear
	java -jar build/jar/Compilador.jar $FILEPATH
else
        cd language
	ant
	cd ..
fi

