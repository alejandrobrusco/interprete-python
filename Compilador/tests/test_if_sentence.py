
print "\nSentencia If:\n"

entero1=1
entero2=45
entero3=-67
booleano1=True

entero4=0
booleano2=False

print "entero1=",entero1
print "entero2=",entero2
print "entero3=",entero3
print "entero4=", entero4
print "booleano1=",booleano1
print "booleano2=",booleano2

print "TOTAL IF SENTENCES = 6"
count = 0;

if entero1:
	print "el entero1 es 1"
	count = count + 1;

if entero2:
	print "el entero2 es positivo"
	count = count + 1;

if entero3:
	print "el entero3 es negativo"
	count = count + 1;

if booleano1:
	print "el booleano1 es True"
	count = count + 1;

if not entero4:
	print "el entero2 es 0"
	count = count + 1;

if not booleano2:
	print "el booleano2 es False"
	count = count + 1;


print "ALL IF EXECUTED=", count==6

