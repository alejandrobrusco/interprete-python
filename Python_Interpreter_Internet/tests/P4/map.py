def mapn(f, l, n):
    i = 0
    new_l = []
    while i != n:
        new_l = new_l + [f(l[i])]
        i = i + 1
    return new_l

print mapn(lambda x: x + 1, [1,2,3], 3)
    
