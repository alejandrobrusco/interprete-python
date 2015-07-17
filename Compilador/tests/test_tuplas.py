
print "\nTuplas:\n"

t = ('Fing', 5, True, True, False, 45.67, [5,6,7])

print "t=", t

i=0
for v in t:
	tmp = t[i]
	print "t[",i,"] = ", tmp
	i=i+1

t1 = (1)
print "t1 =", t1
print "type(t1) =", type(t1)

t2 = (1,)
print "t2 =", t2
print "type(t2) =", type(t2)

print "t[:] =", t[:]
print "t[3:] =", t[3:]
print "t[:4] =", t[:4]
print "t[3:6] =", t[3:6]
print "t[3:6] =", t[3:6]
print "t[::2] =", t[::2]
print "t[1:7:4] =", t[1:7:4]