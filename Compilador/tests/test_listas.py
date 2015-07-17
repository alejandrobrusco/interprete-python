
a = {"Entero": 5, "String_simple": 'String', 'String_doble': "doble"}
print a

lista1 = ["hola",1,4.6,True,["l","i","s","t","a"],(1,4.6,"String"), {"Nombre": "Andres", 4: "Edad"}, {"Edad":5, 5:"Edad"}]

print "lista1=", lista1

print "Con indices positivos:\n"
i=0
for item in lista1:
	print "lista1[",i,"] = ", lista1[i]
	i=i+1

print "Con indices negativos:\n"
i=0
j=-1
for item in lista1:
	print "lista1[",j,"] = ", lista1[j]
	i=i+1
	j=j-1

print "\nSublistas:\n"

lista2 = [51,52,53,54,55,56,57,58,59,60,61,62]

sublista1 = lista2[:]
sublista2 = lista2[0:11]
sublista3 = lista2[4:9]
sublista4 = lista2[:7]
sublista5 = lista2[3:]
sublista6 = lista2[3:24]
sublista7 = lista2[-67:5]
sublista8 = lista2[-67:24]
sublista9 = lista2[::2]
sublista10 = lista2[3:8:2]
sublista11 = lista2[:8:2]
sublista12 = lista2[::]

print "lista2=",lista2
print "lista2[:]=",sublista1
print "lista2[0:11]",sublista2
print "lista2[4:9]",sublista3
print "lista2[:7]",sublista4
print "lista2[3:]",sublista5
print "lista2[3:24]",sublista6
print "lista2[-67:5]",sublista7
print "lista2[-67:24]",sublista8
print "lista2[::2]=",sublista9
print "lista2[3:8:2]",sublista10
print "lista2[:8:2]",sublista11
print "lista2[::]",sublista12

lista4= [1]
lista5= []

sublista13 = lista4[0:0]
sublista14 = lista4[0:4]
sublista15 = lista5[2:6]
sublista16 = lista5[0:8:2]

print "lista4=",lista4
print "lista4[0:0]",sublista13
print "lista4[0:4]",sublista14

print "lista5=", lista5
print "lista5[2:6]",sublista15
print "lista5[0:8:2]",sublista16


print "\nAsignaciones:\n"


lista3 = [1,2,3,4,5,6,7,8,9]
print "lista3=",lista3

toAdd = ["lista","que","agregamos"]
print "toAdd=",lista3

lista3[1:5] = toAdd
print "lista3[1:5] = toAdd ->", lista3

lista3 = [1,2,3,4,5,6,7,8,9]
lista3[:5] = toAdd
print "lista3[:5] = toAdd ->", lista3

lista3 = [1,2,3,4,5,6,7,8,9]
lista3[3:] = toAdd
print "lista3[3:] = toAdd ->", lista3

lista3 = [1,2,3,4,5,6,7,8,9]
lista3[5] = toAdd
print "lista3[5] = toAdd ->", lista3

lista3 = [1,2,3,4,5,6,7,8,9]
lista3[-2] = toAdd
print "lista3[-2] = toAdd ->", lista3