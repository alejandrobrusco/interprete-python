a = {1.0:True}
print a
print 1.0 == 1
print a[1]
a = {3: 0, 2 : 1, 1: 3}
b = {True: False, False: True}
print a[3],a[2],a[1]
print b[True],b[False]
print b[0],b[1]
c = [a,b]
print c[0][1],c[0][2],c[0][3],c[1][0],c[1][1]
d = {3: 5, False: True, True : False, 4.0: True, -1: b}
print d[3],d[False],d[True],d[4],d[-1]
c = d[True]
print d[True]
print d[False]
print [a,b][d[True]][3]
print d[[True][0]]


c = [1,2,3]
d = [1,2,3]
print d[0], c[0]
print d[0] is c[0]
print d[0] is c[False+1]
print d is c[False]
d = c[0]
print d is c[0]


