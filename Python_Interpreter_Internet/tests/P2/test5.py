#! /usr/local/bin/python

###-----------------------------------------------------------###
# 8/30/07                                                       #
#test5.py -- test a piece of the binray_op                      #
#binary_op ::= "%" | "**"                                       #
#expression ::= integer                                         #
#                                                               #
#specifically check                                             #
#                                                               #
#                                                               #
###-----------------------------------------------------------###

print 2**2
print -2**3
print -(2**3)
print (-2)**3
print 6**6

print 9%4
#print -9%4    <-----------------------
print 10%5

##order of operation
print 6*3**2        #** binds more tightly than * or /
print (6*3)**2
print -2**4         #** binds more tightly than unary -,+
print (-2)**4
print -2**3
print (-2)**3

##edge of limits
print 2**30                     #in
#print 2**31 - 1                 #out and caught
#print 2**30 + 1073741824        #out and caught
print 2**30 + 1073741823        #in

print -2**30                    #in
#print -2**31                    #out and caught
print -2**30 - 1073741824       #in
#print -2**30 - 1073741825       #out and caught
#print 30**30        #out and caught
print 30**0         #in
#print 1 % 9000      #out

print 1+2%3
print 1%2+3
print 1-2%3
print 1%2-3
print 1*2%3
print 1%2*3
print 1/2%3
print 1%2/3
