## First 25 number of the Fibonacci Sequence
n = 25

i = 0
last_num = 0
num = 1

print last_num
print num

while i < n:
    new_num = num + last_num
    print new_num
    last_num = num
    num = new_num
    i = i + 1
