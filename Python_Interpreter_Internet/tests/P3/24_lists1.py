print []
print [3]
print [3,True,1.0]

k = [[1,2]]
j = k[0]

j[0] = 3
print j,k
print j is k[0]

print [[]]
print [[],[[[]]],[3]],[]

print [3] + [5]

print [] == [] == [] == []

print 3 * [3]
print [3] * 4
print [3] * True
print [3] * False
print True * [3]
print False * [3]
