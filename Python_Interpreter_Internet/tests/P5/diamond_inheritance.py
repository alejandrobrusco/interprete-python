class A:
    x = 4

class B(A):
    pass

class C(A):
    pass

class D(B, C):
    pass

print D.x
print B.x is C.x

B.x = 42

print C.x
print A.x
print B.x is C.x

A.x = 3

print C.x
print B.x
