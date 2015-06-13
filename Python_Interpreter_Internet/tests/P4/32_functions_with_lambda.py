def fun():
    print a
    return (lambda x,y: a + x + y)
a = 7
print fun()(2,3)
