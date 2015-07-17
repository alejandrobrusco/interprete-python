
print "\nSentencia While\n"

i=0
count_pares = 0

while (i<15):
	print "i=",i

	if (i%2==0):
		count_pares = count_pares + 1

	i = i+1

print "\nSentencia While - Break:\n"

j=0
while (j<50):

	print "j=", j

	if (j>12):
		break 

	j = j+2

if (j==49):
	print "No sali por el break"
else:
	print "Sali por sentencia break"

print "\nSentencia While - Continue:\n"

k=70
while (k<80 and k>=70):
	
	if (k==74 or k==75 or k==76):
		k= k+1
		continue

	print "k =",k
	k = k+1
	