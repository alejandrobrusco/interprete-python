
print "\nSentencia For:\n"

a = [1,2,3,4,5,6,7]

b = {'Clave1':34, True:1,False:0,2:"Dos"}

c = ("Una cadena", 34, 56.88, True, [99,98,97])

print "a=",a
print "b=",b
print "c=",c

print "\nFor a:\n"
for i in a:
	print "Elemento del for:",i

print "\nFor b:\n"
for i in b:
	print "Elemento del for:",i

print "\nFor c:\n"
for i in c:
	print "Elemento del for:",i

print "\nSentencia For - Break:\n"

print "\nFor a:\n"
for i in a:
	print "Elemento del for:",i

	if (i==5):
		break 

print "\nFor b:\n"
for i in b:
	print "Elemento del for:",i

	if (i==False):
		break 

print "\nSentencia For - Continue:\n"

print "\nFor a:\n"
for i in a:

	if (i==3 or i==5):
		continue 

	print "Elemento del for:",i
