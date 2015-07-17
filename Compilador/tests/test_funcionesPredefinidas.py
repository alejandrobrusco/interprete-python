### FUNCIONES PREDEFINIDAS PARA DICCIONARIOS ###
d = {"uno":1,"dos":2,"tres":3,"cuatro":4,"cinco":5}
print "Test funciones predefinidas para diccionarios"
print " Diccionario de prueba ->",d
print "---------------------------------------------------------------"
print " *Chequeo funcion has_key con clave 'cuatro' -> Result:", d.has_key("cuatro")

items = d.items()
print " *Chequeo funcion items -> Result:", items
print "  >type ->",type(items)
print "  >type de elemento 0 ->",type(items[0])

keys = d.keys()
print " *Chequeo funcion keys -> Result:", keys
print "  >type ->",type(keys)
print "  >type de elemento 0 ->",type(keys[0])

values = d.values()
print " *Chequeo funcion values -> Result:", values
print "  >type ->",type(values)
print "  >type de elemento 0 ->",type(values[0])

cuatro = d.pop("cuatro")
print " *Chequeo funcion pop con clave 'cuatro' -> Result:", cuatro
print "  >type ->",type(cuatro)
print "  >d.has_key(\"cuatro\") ->",d.has_key("cuatro")
print "  >diccionario luego del pop ->",d
print "---------------------------------------------------------------\n"

### FUNCIONES PREDEFINIDAS PARA STRINGS ###
str1 = "Un sueno sonaba anoche,"
str2 = "Sonito del alma mia,"
str3 = "Sonaba con mis amores"
str4 = "Que en mis brazos los tenia."
str5 = """Vi entrar senora tan blanca
Muy mas que la nieve fria."""
vocales = "aeiou"
regex = ","
regex2 = ""
print "Test funciones predefinidas para Strings"
print " >Strings para pruebas ->",str1
print " >Strings para pruebas ->",str2
print " >Strings para pruebas ->",str3
print " >Strings para pruebas ->",str4
print " >Strings para pruebas ->",str5
print "---------------------------------------------------------------"
print " *Chequeo funcion str.count(str2)"
print "  >con 'n' sobre:'",str1,"' -> Result:", str1.count("n")
print "  >con 'a' sobre:'",str2,"' -> Result:", str2.count("a")
print "  >con 'o' sobre:'",str3,"' -> Result:", str3.count("o")
print "  >con 'e' sobre:'",str4,"' -> Result:", str4.count("e")
print "  >con 'i' sobre:'",str5,"' -> Result:", str5.count("i")

print " *Chequeo funcion str.find(str2)"
print "  >con 'n' sobre:'",str1,"' -> Result:", str1.find("n")
print "  >con 'a' sobre:'",str2,"' -> Result:", str2.find("a")
print "  >con 'o' sobre:'",str3,"' -> Result:", str3.find("o")
print "  >con 'e' sobre:'",str4,"' -> Result:", str4.find("e")
print "  >con 'i' sobre:'",str5,"' -> Result:", str5.find("i")

print " *Chequeo funcion str.find(str2,int)"
print "  >con 'n' y 4 sobre:'",str1,"' -> Result:", str1.find("n",4)
print "  >con 'a' y 14 sobre:'",str2,"' -> Result:", str2.find("a",14)
print "  >con 'o' y 2 sobre:'",str3,"' -> Result:", str3.find("o",2)
print "  >con 'e' y 24 sobre:'",str4,"' -> Result:", str4.find("e",24)
print "  >con 'i' y 15 sobre:'",str5,"' -> Result:", str5.find("i",15)

print " *Chequeo funcion str.join(str2)"
print "  >con ',' sobre:'",vocales,"' -> Result:", regex.join(vocales)
print "  >con ',' sobre:'' -> Result:", regex.join("")
print "  >con '' sobre:'",vocales,"' -> Result:", regex2.join(vocales)

toSplit = "a,e,i,o,u"
print " *Chequeo funcion str.split(str2)"
print "  >con ',' sobre:'",toSplit,"' -> Result:", toSplit.split(",")

print " *Chequeo funcion str.replace(str2)"
print "FAAAAAAAAAAAAAAAAALLLLLLLLLLLLLLLLLLLTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"

print " *Chequeo funcion str.length()"
print "  >sobre:'",str1,"' -> Result:", str1.length()
print "  >sobre:'",str2,"' -> Result:", str2.length()
print "  >sobre:'",str3,"' -> Result:", str3.length()
print "  >sobre:'",str4,"' -> Result:", str4.length()
print "  >sobre:'",str5,"' -> Result:", str5.length()
print "---------------------------------------------------------------\n"