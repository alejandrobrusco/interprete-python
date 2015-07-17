
print "\nSentencias If-Else:\n"

a = raw_input("Indique un valor de tipo entero:")

eleccion = int(a)

if eleccion:
	print "Selecciono un Entero distinto de 0 y ejecuto el IF"
else:
	print "Selecciono un Entero igual a 0 y ejecuto el ELSE"


print "\nMas pruebas:\n"

a=0
print "a=",a

b=45

if type(a)==type(b):
	a=120
	b=45.2
else:
	print "No ejecutamos nunca este else!"

if (type(a)==type(b)):
	print "No deberiamos entrar a este IF"
else:
	print "Cambiamos los tipos, entonces entro al ELSE"




