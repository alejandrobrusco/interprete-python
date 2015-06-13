C = 38
def make_class1():
    class C:
        x = 3
        def __init__(self):
            self.x = 4
    return C
def make_class2():
    class C:
        x = 38
        def __init__(self):
            self.x = 4 + C.x
    return C
o = make_class1()()
print o.x + C

o = make_class2()()
print o.x
