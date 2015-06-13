def fun():
    print a
    return (lambda x,y: a + x + y)

def side_effect():
    print 0
    return 0

a = 7
l = [fun()]
print l[side_effect()](2,3)

