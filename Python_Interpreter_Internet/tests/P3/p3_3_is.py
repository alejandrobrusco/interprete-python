print {1:3} > {1:3}
print {1:3, 3:4} < {1:3}
print {1:3, 5:True} < {1:3, 5:2}
print {1:3, 5:True} <= {1:3, 5:2}
print {1:3, 5:2} <= {1:3, 5:2}
print {1:3, 5:True} > {1:3, 5:2}
print {1:3, 5:True} >= {1:3, 5:2}
print {1:3, 5:2} >= {1:3, 5:2}
print {3:4, 2:2} == {2:2, 3:4}
print {3:4, 2:2} != {2:2, 3:4}
print {3:4, 2:2} is {2:2, 3:4}
print 5 == 5.0
print [1, 2] is [1, 2]
print [1, 2] == [1, 2]
print [1, 2] != [1, 2]
print [1, 2] >  [1, 2]
print [1, 2] <  [1, 2]
print [1] < [1,2]
print [1,3] > [1,2]
print [1,2] >= [1,2]
print [1,3] <= [1,2]
print [1.0, 3] <= [1, 3]
print [[5], 3] < [[4], 3]
print [.9, 2] < [1, .9]

print {} < {5:1}



