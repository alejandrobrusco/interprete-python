#! /usr/local/bin/python

###-----------------------------------------------------------###
# 9/07                                                          #
#test12.py -- 			                                #
#								#
# while								#
#                                                               #
###-----------------------------------------------------------###
o = 10
p = 10
while o:
  o = o -1
  print o
  while p:
    p = p - 1
    print p
  if not p:
    print o+p
if not o: 
  p = o
print o
print p

o = 10
p = 10
while o:
  o = o -1
  print o
  while p:
    p = p - 1
    print p
  if not p:
    o = o*1.0
    print o+p
if not o: 
  p = o
print o
print p

x = 10
while x:
  x = x - 1
  print x
if not x:
  x = 2.0
  x = True
  x = False
  x = 9000
  print x
print x

x = 10
while x > 0:
  x = x * 1.0
  x = x * 1
  x = x * True
  x = -x
  x = +x
  x = x - 1.0
  x = x - 1
  print x
if not (x > 0):
  x = 9000
print x

te = 5
te = True
print True
print te

i = 0
print i
while i < 2:
    i = i + 1
    print i


i = 0
while i < 2:
    i = i + 1
    print i
if not (i < 2):
    print 1000

i = 10
while i < 2:
    print 1
if not (i < 2):
    print 2

q = 0
w = 10
while q < w:
    print q
    q = q + 1

g = 0
while g < 10:
    g = g + 1
    print g
if not (g < 10):
    g = 500.0
    k = 9
print g

a = 0
s = 100
while a < s:
    x = 0
    a = a + 10
    s = s + 1
    print a


