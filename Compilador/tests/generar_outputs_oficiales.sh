#!/bin/bash

for i in $(ls *.py); do
	python $i > ${i}_output.txt;
done
