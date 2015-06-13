f = lambda z: x
class C:
    x = 3
    foo = f
x = 72
print C.foo(C())
