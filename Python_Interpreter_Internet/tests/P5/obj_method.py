class C:
    def f(self):
        print self.x

a = C()
a.x = 42

a.f()
        
