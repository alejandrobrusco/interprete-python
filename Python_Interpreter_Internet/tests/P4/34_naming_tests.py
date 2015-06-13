def fun():
    print a
    return (lambda x,y: a + x + y)

a = 7
f = fun()
print f(a,a)
