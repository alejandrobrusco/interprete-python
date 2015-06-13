def fun():
    a = 2
    print a
    return a
fun()


def fun_param(a,c):
    print a
    if c > 0:
        fun_param(c,c-1)

fun_param(0,30)

