x = 5
def foo3(y):
    z = y+2
    def foo4(a):
        print x, y, z, a
        def foo5(c):
            return foo4(5) + c
        if(a == 9):
            print foo5(5)
        else:
            pass
        a = 6
        return x+y+z

    foo4(y)
    y = y + 2
    foo4(y)

    return foo4

print foo3(3)(9)

