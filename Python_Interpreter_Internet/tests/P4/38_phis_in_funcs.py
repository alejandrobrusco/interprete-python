

needs_heep = 0
def have_fun(y):
    x = 5
    z = 3.0
    while x > 0 and y > 0 and z > 0:
        y = 5
        while y > 0:
            while x > 0:
                if x > 3:
                    f = x
                    w = 4.0
                else:
                    w = 4
                print x, y, z, w
                x = x - 1
            y = y - 1
        z = z - 1
    print needs_heep
    return z

print have_fun(5)
x = 8
needs_heep = 3
print have_fun(5)
print x
