############################################################################################

print "\nDefinicion funciones Simples:\n"

def printSaludo():

	print "Hola! Funcion que te saluda"

def aritmetica(a,b,c):

	x=4
	y=2
	a=a+x
	b=b+y
	return a+b-c


printSaludo()

var1=4
var2=5
var3=10

print "var1=",var1
print "var2",var2
print "var3=",var3
print "aritmetica(var1,var2,var3)=", aritmetica(var1,var2,var3)
print "aritmetica(b=var2,c=var3,a=var1)=", aritmetica(b=var2,c=var3,a=var1)


############################################################################################

print "\nDefinicion funciones Listas por parametro:\n"

def porReferenciaLista(l1):
		l1[0:4] = ["nueva","lista"]
		
		return True

lista = [1,2,3,4,5,6]

print "lista=",lista

if (porReferenciaLista(lista)):
	print "Entre al if y modifique las variables"

print "lista=",lista

def porReferenciaDic(d1):

	d1["nueva_clave"]= 56
	d1[False]=0

dic = {False:1, "Sin_cambios":45.7}

print "dic[False]=",dic[False]
porReferenciaDic(dic)
print "dic[False]=",dic[False]
print "dic[nueva_clave]=",dic["nueva_clave"]