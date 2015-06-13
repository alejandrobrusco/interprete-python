b = { 5.5: True, False: 30, 0: 10 }
a = { 0: 0.0 }
b[4] = a
print b[5.5], b[0], b[4]

print { 1: 0 }
print { 0.5: 5.5 }
print { True: False }
print {}
a = {}
print a
a = { 0: 5 }
a[False] = True
print a
a = { 0: 5 }
print a
a[5] = True
print a
a[5] = 100
print a
l = [5, 10, True]
a = { 0: 0.0, 1: 1.0, 2: 2.5 }
print a[1]
a[1] = l
print a[1]
a[1][2] = 10.0
print a[1]
