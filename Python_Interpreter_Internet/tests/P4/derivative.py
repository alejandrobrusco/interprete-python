def derivative(f):
    epsilon = 0.0001
    return lambda(x): (f(x+epsilon) - f(x)) / epsilon
def square(x):
    return x * x
print square(10)
ds = derivative(square)
print ds(10)

