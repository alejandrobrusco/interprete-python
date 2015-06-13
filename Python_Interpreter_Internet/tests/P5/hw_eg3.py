class C:
    def __init__(o, n):
        print n
o = C(42)

o.x = 7
print o.x

p = C(42)
p.x = 10
print o.x, p.x

print o is p
q = o
print q is o
q.x = 1
print o.x

