class C:
    x = 42
print C.x

class C:
    print 4 * 10 + 2

class C:
    def __init__(self, x):
        self.x = x
    f = lambda o, dx: o.x + dx
print C.f(C(1), 3)
    
class C:
    x = 42
class D:
    x = 0
print (C if True else D).x

