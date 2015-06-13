#! /usr/local/bin/python

###-----------------------------------------------------------###
# 9/07                                                          #
#test11.py -- 			                                #
#								#
# variables							#
#                                                               #
###-----------------------------------------------------------###
op = True
print op

v = 0
if True:
  v = 0
  v = 1.1
  v = False
else:
  v = 4
  v = 3.5

print v

if True:
  g = 1
else:
  g = 1.0
print g


wq = 100
rt = 5
if wq < rt:
  yep = 1
else:
  yep = 1.0
print yep

x=3
print x
x=4.5
print x
x=True
print x

x=3
if x == 20:
    x = 1000
print x

x=0
while x < 10:
    x = x + 1
    y = 1.0
    print y, x
    temp = x
    x = y
    print x
    x = temp
print 10000000

x=0
while x < 10:
    x = x + 1
    if x == 2:
	#break
	print 99
    print x

x=0
while x < 10:
    x = x + 1
    if x == 2:
	#continue
	print 99
    print x
    
x=0
while x < 10:
    x = x + 1
#    continue
    print 99
    print x

x=0
while x < 10:
    x = x + 1
    #break
    print 99
    print x

t = 0
while t < 10:
    if t%2 == 0:
       t = t * 1.0
    else:
       t = t * 1.0
    t = t + 1
    print t
    print x

print 9999

r = 0
print r
while r < 10:
    if r%2 == 0:
       if r == 6:
	  print 100000000
      	  r = r * 1.0
	  print r
    else:
       r = r * 1
    print r
    r = r + 1
    print 55555
    print r
    print x

r = 0
print r
while r < 10:
    if r%2 == 0:
       if r == 6:
	  print 100000000
      	  r = r * 1.0
	  print r
       r = r + 1
    else:
       r = r * 1
    print r
    r = r + 1
    print 55555
    print r
    print x


