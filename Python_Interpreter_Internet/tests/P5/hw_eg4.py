class C:
    def __init__(o, n):
        print n
o = C(42)

o.f = lambda n: n * n
print o.f(3)

class C:
    y = 3
o = C()
print o.y

class C:
    def __init__(self):
        self.x = 0
    def move(o, dx):
        o.x = o.x + dx
o = C()
f = o.move
f(1)
print o.x

mlist = [o.move, o.move, o.move]
i = 0
while i != 3:
    mlist[i](1)
    i = i + 1
print o.x
