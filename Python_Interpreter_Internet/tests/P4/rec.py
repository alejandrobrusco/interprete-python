def rec(x):
    if x == 1:
        return 0
    print rec(1)
    print x
    if x == 0:
        return 0
    rec_ = lambda x: rec(x)
    return rec_(x-1)

print rec(10)
