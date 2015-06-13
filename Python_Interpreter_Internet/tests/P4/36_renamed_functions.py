k = 7
x = 5

def foo3(y):
    def k():
        return lambda x: 3
    print k()(4)
    def named():
        return k

    print named()()(y)
    def k():
        return lambda x: 7
    z = y+2
    def foo4(a):
        print x, y, z, a
        def foo5(c):
            return foo4(5) + named()()(c)
        if(a == 9):
            print foo5(5)
        else:
            pass
        a = 6
        return x+y+z
    return foo4

print foo3(3)(9)

