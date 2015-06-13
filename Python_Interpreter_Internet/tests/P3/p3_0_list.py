print [1,2.5,False]
a = [1,2.0, True]
print a
b = [4, True, a]
print b, b[1]
print a, b[2][1]
a = b
print a, b
a[2][1] = 100
print a,b
c = [a, b]
print c
print c[0][2][0], c[1][2][2]
c[1][2][2] = 5.5
print c,a,b
c = []
print c
c = [] + []
print c
print c+a
d = a+b+c
print d
d[0] = 500
d[2][0] = False
print [1,2] + [5.0, True, 20]
