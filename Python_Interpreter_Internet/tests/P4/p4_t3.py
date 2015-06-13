def map(f, n, ls):
    i = 0
    ret = []
    while i != n:
        ret = ret + [f(ls[i])]
        i = i + 1
    return ret
print map(lambda x: x + 1, 3, [1,2,3])
