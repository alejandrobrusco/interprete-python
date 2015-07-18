@ECHO OFF
mkdir salidas
FOR %%A IN (salidas\?????????????????????????????????.txt) DO del "%%A"

echo ""
echo "Se generaran las salidas de Python y del proyecto propio"
echo ""
echo "Hay tests que dan ERROR intencionalmente y por lo tanto se mostraran esos errores en pantalla"
pause

FOR %%i IN (test*.py) DO (
	python %%i > salidas/%%i_output.txt
	java -jar ../build/jar/Compilador.jar %%i >salidas/%%i_output_propio.txt
)

cls
echo "Pueden haber diferencias entre las salidas de Python y el proyecto propio porque:"
echo "- Los elementos de un diccionario no tienen un orden"
echo "- Errores de redondeo en divisiones y potencias"
pause

FOR %%i IN (test*.py) DO (
	cls	
	echo "------------------- DIFF de %%i -------------------"
	diff.exe salidas/%%i_output.txt salidas/%%i_output_propio.txt
	echo ""
	echo "--------------------------------------------------------------------"
	echo "PRESIONA UNA TECLA PARA IR AL SIGUIENTE TEST"
	pause
)

cls
echo "FIN de tests automaticos!"

echo "Los siguientes tests deben realizarse de forma manual porque requieren interaccion con el usuario:"
FOR %%i in (manual*.py) DO (
	echo %%i
)
echo ""
echo "FIN DEL SCRIPT"
