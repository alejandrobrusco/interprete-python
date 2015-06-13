print input() + input()

print
print

print 1 * -1 / 4 - 8 - 8
print ( 1 * -1 ) / ( 4 * ( 1 ) )
print ( 1 * -1 ) / ( 4 * ( 8 - 7 ) )

print
print


c = [[1,2],2,3,4]
d = [[2,3],2,3,4]

c = [1,2]
d = [3,4]


c = [1,1,1,3]
print c
print d
c = [[1,2]]
print c
print d

a = 0
b = [[a]]
c = [[b]]

print a,b,c

print
print

x = 0
while (x < 10):
    print x
    x = x + 1
    if (x % 2 == 0):
        x = x + 1
    else:
        x = x + 1.5

print

x = -1
while (x > -10):
    x = x * -2.0
    if x == -4:
        print x - 100
    else:
        print x

while (x > 10):
    x = z / 2.0
    print x, z
    if (x > 20):
        z = x
    else:
        z = x+8
        y = 10000

print
print

if False:
    b = 3
    print b
else:
    b = 2

print b

if False:
    b = 3.0
    print b

print
print

def fun():
    a = 2
    print a
    return a
fun()


def fun_param(a,c):
    print a
    if c > 0:
        fun_param(c,c-1)

fun_param(0,30)

print
print

g = lambda x: x**2
print g(8)


