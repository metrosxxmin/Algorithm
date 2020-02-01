
def gcd(m, n):
    while n != 0:
        t = m % n
        m, n = n, t
    return abs(m)


def lcm(m, n):
    return m*n // gcd(m, n)
