class C:
    pass

a = C()
b = C()

a.x = 4
b.x = 2

print a.x * 10 + b.x
