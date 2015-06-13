def f(g):
    return g()

def h():
    x = 4
    g = lambda: x + 1
    x = 7
    return g

print f(h())
