class C:
    pass

x = C()

def hw():
    print 42
    
x.f = hw
x.f()
