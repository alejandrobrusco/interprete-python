def sum(l, n):
    i = 0
    s = 0
    while i != n:
        s = s + l[i]
        i = i + 1
    return s
print sum([1,2,3], 3)
print sum([4,5,6], 3)

