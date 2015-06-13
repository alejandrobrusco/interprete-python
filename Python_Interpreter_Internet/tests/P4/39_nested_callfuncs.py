def k():
    print 42
    return lambda x: x

def named():
    return k

j = k

l = j()
print l(4)
z = k()
print z(4)
print k()(4)

def k():
    print 43
    return lambda x: 7

print k()(4)

print named()()(4)

