
x = [1,2] + [6,7]
print x

e = {1:2,3:4}

f = {1:2,3:4}

print e == f

f = {3:4,1:2}
print e == f
e[0.0] = 1024.1024
e[1] = [1,2,3]
print e[1],e[False],e[3],e[4-3.0-False]
print e[1]
print e[False]
print e[True]

print not e
print not not e == True

print 1.0 == 1
