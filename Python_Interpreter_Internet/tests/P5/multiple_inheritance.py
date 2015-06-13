class A:
    x = 4

class B:
    x = 0
    y = 2

class C(A, B):
    pass


print C.x * 10 + C.y
