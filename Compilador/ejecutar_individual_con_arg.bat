@ECHO OFF
java -jar build\jar\Compilador.jar %1 > %1_output_propio.txt
type %1_output_propio.txt
