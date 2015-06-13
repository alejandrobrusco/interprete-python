class C:
    def f(self):
        print 0

x = C()

def print_the_answer():
    print 42

x.f = print_the_answer
x.f()
