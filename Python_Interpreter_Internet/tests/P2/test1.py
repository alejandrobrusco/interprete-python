#! /usr/local/bin/python

###-----------------------------------------------------------###
# 8/30/07                                                       #
#test1.py -- test the simple_statement                          #
#simple_statement ::= "print" expression ("," expression)*      #
#expression ::= integer                                         #
#                                                               #
#specifically check                                             #
#int limits and comma separated                                 #
#                                                               #
###-----------------------------------------------------------###

#single integer
print 1
print 100
print 0

#comma separated integers
print 1,2,3,4,5,6,7
print 345,7645,345,654

#int limits
print 2147483647   #in range
#print 2147483648      #out and caught
print 2147483646, 2147483647, 2147483000
