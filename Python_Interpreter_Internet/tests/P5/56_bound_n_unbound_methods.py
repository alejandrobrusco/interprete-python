
class C:
    j = lambda x: x + 7
    f = lambda o,x: x + 3
    def fun(self,x):
        print x

o = C()

print C.f(o,3)
C.fun(o,2)

print o.f(5)
o.fun(42)


