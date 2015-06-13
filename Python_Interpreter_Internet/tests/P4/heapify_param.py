def f(x):
    y = 0
    g = lambda: x + y
    x = 3
    y = 2
    return g
print f(1)()
