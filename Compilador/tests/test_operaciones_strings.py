cd1 = "cadena1_doble"
cd2 = "cadena2_doble"
cs1 = 'cadena1_simple'
cs2 = 'cadena2_simple'

cl1 = """cadena
larga 1"""

suma1 = cs1 + cd1

suma2 = cs1 + cs2

suma3 = cd1 + cd2

suma4 = cl1 + cd1

mult1 = cd1 * 5

mult2 = cs1 * 10

mult3 = cl1 * 3

print 'cd1 =', cd1
print 'cd2 =', cd2
print 'cs1 =', cs1
print 'cs2 =', cs2

print 'cs1 + cd1 =', suma1
print 'cs1 + cs2 =', suma2
print 'cd1 + cd2 =', suma3
print 'cl1 + cd1 =', suma4
print 'cd1 * 5 =', mult1
print 'cs1 * 10 =', mult2
print 'cl1 * 3 =', mult3