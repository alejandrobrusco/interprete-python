class C:
    f = lambda self: self.x * self.x

a = C()
a.x = 6.4807407

print a.f()
