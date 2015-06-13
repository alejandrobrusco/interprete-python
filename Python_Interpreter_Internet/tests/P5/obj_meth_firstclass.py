class C:
    def print_x(self):
        print self.x

a = C()
a.x = 0
f = a.print_x
a.x = 42
f()
