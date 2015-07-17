print "\nElemenos de diccionario:\n"

d = {"Clave1": 1, 'Clave2': 2, 3: "valor de clave entera 3", True : 1, False:0 , "Valor de flotante": 123.8345, 45.78 : "valor con clave floatante"}

print "d =",d
print "d[\'Clave1\'] =", d["Clave1"]
print "d[\'Clave2\'] =", d['Clave2']
print "d[3] =", d[3]
print "d[True] =", d[True]
print "d[False] =", d[False]
print "d[\'Valor de flotante\'] =", d["Valor de flotante"]

print "\nCambiamos elementos por clave:\n"

print "d['Clave1'] =", d["Clave1"]
d["Clave1"] = "un nuevo valor"
print "d['Clave1'] =", d["Clave1"]

print "d[True] =", d[True]
d[True] = 'ahora tenemos el string falso'
print "d[True] =", d[True]

d[456] = 456.80
print "d[456]=", d[456]

print "d =",d