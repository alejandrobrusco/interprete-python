#!/bin/bash
FILEPATH=${1}
java -jar build/jar/Compilador.jar ${FILEPATH} > ${FILEPATH}_output_propio.txt
cat ${FILEPATH}_output_propio.txt
