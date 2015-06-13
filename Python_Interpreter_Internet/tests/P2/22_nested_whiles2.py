#if True:
#    z = 3
#    print z
#
#if z:
#    print z
z = 3

a = 0
while a < 10:
    print z
    print a

    a = a + 1
    if a == 5:
        b = 5
        print b
        while b > 0:
            print a - b
            b = b - 1.0
            c = b
            if c:
                print a,b,c
                c = c + True
                z = c
            if z:
                print z
            print z


        print b


print z
print a,b,c,z

