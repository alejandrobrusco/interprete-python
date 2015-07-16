# valores a utilizarse
print "\nValores utilizados para la prueba:\n"

a=5
b=3
c=-3

x=10L
y=-4L
z=4L

print "a=",a, " -> tipo de a", type(a)
print "b=",b, " -> tipo de b", type(b)
print "c=",c, " -> tipo de c", type(c)

print "x=",x, " -> tipo de x", type(x)
print "y=",y, " -> tipo de y", type(y)
print "z=",z, " -> tipo de z", type(z)

# enteros
print "\nOperaciones de enteros:\n"

print "\n(Entre positivos)\n"

print "a&b=", a&b, " -> tipo a&b", type(a&b)
print "a|b=", a|b, " -> tipo a|b", type(a|b)
print "a^b=", a^b, " -> tipo a^b", type(a^b)
print "~b=", ~b, " -> tipo ~b", type(~b)
print "a<<b=", a<<b, " -> tipo a<<b", type(a<<b)
print "a>>b=", a>>b, " -> tipo a>>b", type(a>>b)

print "\n(Positivo y negativo)\n"

print "a&c=", a&c, " -> tipo a&c", type(a&c)
print "a|c=", a|c, " -> tipo a|c", type(a|c)
print "a^c=", a^c, " -> tipo a^c", type(a^c)
print "~c=", ~c, " -> tipo ~c", type(~c)
print "a<<c=", a<<c, " -> tipo a<<c", type(a<<c)
print "a>>c=", a>>c, " -> tipo a>>c", type(a>>c)

# long
print "\nOperaciones de longs:\n"

print "\n(Entre positivos)\n"

print "x&z=", x&z, " -> tipo x&z", type(x&z)
print "x|z=", x|z, " -> tipo x|z", type(x|z)
print "x^z=", x^z, " -> tipo x^z", type(x^z)
print "~z=", ~z, " -> tipo ~z", type(~z)
print "x<<z=", x<<z, " -> tipo x<<z", type(x<<z)
print "x>>z=", x>>z, " -> tipo x>>z", type(x>>z)

print "\n(Positivo y negativo)\n"

print "x&y=", x&y, " -> tipo x&y", type(x&y)
print "x|y=", x|y, " -> tipo x|y", type(x|y)
print "x^y=", x^y, " -> tipo x^y", type(x^y)
print "~y=", ~y, " -> tipo ~y", type(~y)
print "x<<y=", x<<y, " -> tipo x<<y", type(x<<y)
print "x>>y=", x>>y, " -> tipo x>>y", type(x>>y)

# int and long
print "\nOperaciones de entero y long:\n"

print "\n(Entre positivo)\n"

print "a&z=", a&z, " -> tipo a&z", type(a&z)
print "a|z=", a|z, " -> tipo a|z", type(a|z)
print "a^z=", a^z, " -> tipo a^z", type(a^z)
print "~z=", ~z, " -> tipo ~z", type(~z)
print "a<<z=", a<<z, " -> tipo a<<z", type(a<<z)
print "a>>z=", a>>z, " -> tipo a>>z", type(a>>z)

print "\n(Int Positivo y Long Negativo)\n"

print "a&y=", a&y, " -> tipo a&y", type(a&y)
print "a|y=", a|y, " -> tipo a|y", type(a|y)
print "a^y=", a^y, " -> tipo a^y", type(a^y)
print "~y=", ~y, " -> tipo ~y", type(~y)
print "a<<y=", a<<y, " -> tipo a<<y", type(a<<y)
print "a>>y=", a>>y, " -> tipo a>>y", type(a>>z)

print "\n(Int Negativo y Long Positivo)\n"

print "x&c=", x&c, " -> tipo x&c", type(x&c)
print "x|c=", x|c, " -> tipo x|c", type(x|c)
print "x^c=", x^c, " -> tipo x^c", type(x^c)
print "~c=", ~c, " -> tipo ~c", type(~c)
print "x<<c=", x<<c, " -> tipo x<<c", type(x<<c)
print "x>>c=", x>>c, " -> tipo x>>c", type(x>>z)