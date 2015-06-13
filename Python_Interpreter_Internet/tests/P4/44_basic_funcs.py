def zero():
    return 0

x = zero()
print x
x = 5

def foo():
    x = 5

foo()
print x

def foo2():
    a = x + 5
    return x

print foo2()
print x

def k():
    return lambda x: x

def named():
    return k

print named()()(4)




