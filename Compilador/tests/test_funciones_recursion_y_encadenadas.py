
print "\nFunciones recursivas:\n"

def factorial(n):

	if (n==0 or n==1):
		return 1

	return n*factorial(n-1)

number = 5

print "number=",5
print "factorial(number)=", factorial(5)


print "\nFunciones dentro de funciones (scope):\n"


def function1(a):

	print a
	c = 5

	def function2(b):

		print b+10

		def function3(x,y):

			print g1
			print x,y

		function3(b,c)

	function2(g1)


g1 = 50
var = 10

print "g1=",g1

print "llamo a funcion1"
function1(10)

print "llamo a funcion2, pero no estoy en el scope para ejecutarla, error?"
#function2()


	







