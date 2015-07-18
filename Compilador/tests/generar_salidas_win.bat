@ECHO OFF
mkdir salidas
FOR %%A IN (salidas\?????????????????????????????????.txt) DO del "%%A"

echo ""
echo "Se generaran las salidas de Python y del proyecto propio"
echo ""

FOR %%i IN (test*.py) DO (
	python %%i > salidas/%%i_output.txt;
)

FOR %%i IN (test*.py) DO (
	java -jar ../build/jar/Compilador.jar %%i >salidas/%%i_output_propio.txt;
)

cls
echo "Pueden haber diferencias entre las salidas de Python y el proyecto propio porque:"
echo "- Los elementos de un diccionario no tienen un orden"
echo "- Errores de redondeo en divisiones y potencias"
pause

FOR %%i IN (test*.py) DO (
	cls	
	echo "------------------- DIFF de %%i -------------------"
	diff.exe salidas/%%i_output?????????????????????????????
	echo ""
	echo "--------------------------------------------------------------------"
	echo "PRESIONA UNA TECLA PARA IR AL SIGUIENTE TEST"
	pause
)

cls
echo "FIN de tests automaticos!"

echo ""
echo "Los siguientes tests deben realizarse de forma manual porque requieren interaccion con el usuario:"
for i in $(ls manual*.py); do
	echo ${i};
done
echo ""
echo "FIN DEL SCRIPT"
