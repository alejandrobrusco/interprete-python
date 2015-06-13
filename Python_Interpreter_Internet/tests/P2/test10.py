#! /usr/bin/python

###-----------------------------------------------------------###
# 9/12/07                                                       #
#test10.py -- if then else	     	                        #
#								#
#                                                               #
###-----------------------------------------------------------###

print 3 if True else 3.4
print 3 if False else 3.4
print True if True else False
print False if 4.5 else 3
print (8*400) if (6*9.4) else (43.8)
print 900.2 if False else True

print 1 and 3
print True and False
print True and 0.0
print 0 and True
print 1 or 3
print 0 or 3
print 0 or 3.141592654
print 1 and 3 or 0
print 1 or 3 and 0.00
print 1 and not 3
print not True
print not False
print not 100
print not 0
print not 100.0
print not 0.0
print not 3 and not ( 3.0 if True else False )
