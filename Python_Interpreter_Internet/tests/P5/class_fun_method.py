def f1(self):
    return self.x

class C:
    f = f1

a = C()
a.x = 42

print f1(a), C.f(a), a.f()
print f1 is  C.f, C.f is a.f

