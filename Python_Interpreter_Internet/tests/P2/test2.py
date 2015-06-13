#! /usr/local/bin/python

###-----------------------------------------------------------###
# 8/30/07                                                       #
#test2.py -- test the unar operation                            #
#unary_op ::= "+" | "-"                                         #
#expression ::= unary_op integer                                #
#                                                               #
#specifically check                                             #
#int limits, 0, () groupings                                    #
#                                                               #
###-----------------------------------------------------------###

#unary_op integer
print -1
print +9
print -1000
print +99999
print --9
print -+320

#()
print (-4)
print +(-4)
print -(-4)
print -(4)
print ((7))
print -(((7)))

#zero
print -0
print +0

#comma separated
print -123, +4432, -3, -9

#int limits
print +2147483647   #in range
#print +2147483648      #out and caught
#print -2147483648   #in range but caught <------------------------
#print -2147483649      #out and caught
