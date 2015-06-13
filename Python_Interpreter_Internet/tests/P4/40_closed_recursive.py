def dec(x):
    local = 7
    return x - 1

def rec(x):
    if x == 1 or x == 0:
        return 0
    print rec(1)
    local = 8
    print x
    x = dec(x)
    rec(x)

def sub():
    local = 9
    print 99
    return lambda: rec

j = sub
x = 20
j()()(x)


