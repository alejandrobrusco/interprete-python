#! /usr/local/bin/python

###-----------------------------------------------------------###
# 8/30/07                                                       #
#test3.py -- test a piece of the binray_op                      #
#binary_op ::= "+" | "-"                                        #
#expression ::= integer                                         #
#                                                               #
#specifically check                                             #
#() groupings, zero, int limits                                 #
#                                                               #
###-----------------------------------------------------------###

print 4+3
print 5-2
print 4-6, 9-1

##()
print (4-4)
print 16+(4-5)
print (10-10)+2
print -16 + 23 + 90
print (+16) + (-12)
print (3+5) - (90-4)
print -(4+5)
print ((3+4)-5)-12
print 90--12

##zero
print 0+0
print 0-0

##comma separated
print 4-9, 9+100, 1000-342

##int limits
print 2147483646 + 1        #in range
#print 2147483647 + 10      #in range but goes out

print -2147483647 - 1       #in range
#print -2147483648 - 1      #out and caught
#print -2147483647 - 2147483647      #in range goes out

#print 2147483648 - 1        #out and caught
#print -2147483649 + 1       #out range and caught
