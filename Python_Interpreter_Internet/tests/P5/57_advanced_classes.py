if True:
    def method(self):
        print 42

method(4)

class ClassWithMethodInIf:
    if True:
        def method(self):
            print 42

o = ClassWithMethodInIf()
o.method()


class C:
    pass

C.x = 3

o = C()
print C.x
o.x = 4

print C.x
print o.x

