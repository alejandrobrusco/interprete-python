def foo(n): return 1000000
def bar(n): return -999999

def z():
    def foo(n):
        if n == 0:
            return 3.14159
        else:
            return bar(n-1)
    def bar(n):
        if n == 0:
            return 2.71828
        else:
            return foo(n-1)
    return [foo,bar]

foobar = z()
print foobar[0](2), foobar[1](2)
