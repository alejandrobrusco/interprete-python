class C:
    def f(self):
        print 1
    def g(self):
        print 2

x = C()

tmp = x.f
x.f = x.g
x.g = tmp

x.f()
x.g()
