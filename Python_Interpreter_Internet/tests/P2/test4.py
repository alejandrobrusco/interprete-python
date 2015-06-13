#! /usr/local/bin/python

###-----------------------------------------------------------###
# 8/30/07                                                       #
#test4.py -- test a piece of the binray_op                      #
#binary_op ::= "*" | "/"                                        #
#expression ::= integer                                         #
#                                                               #
#specifically check                                             #
#order of operation, zero and int limits                        #
#                                                               #
###-----------------------------------------------------------###

print 4*2
print -2*2
print -2*-2

print 4/2
print -4/2
print 4/-2
print -4/-2

print 3*3/2
print 4*4*4/8

##order of operation
print 4/8*4*4   #right to left
print 8/2/2     #right to left

##()
print 8/(2/2)
print (2*3)/(8*9)
print -4*(12/3)
print (12+24)*100
print ((1+1)-15)*100
print 100*(12-(25+30))
print 1+12*4
print 4*12+1


##zero
print 0*0
print 15*0
print 0*15

print 0/15
#print 15/0    #wrong  and caught
#print 15/(4-4)  #division by zero

##int limits
#print 214748364700  #out and caught
print 2147483647/2  #in
#print 2147483648/2  #out and caught

#print -2147483648*2 #out
#print -2147483648/2 #in but caught <------------------
#print -2147483649/2 #out and caught
