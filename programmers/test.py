def sum(a,b):
    return a+b

def abs(a):
    return a if a > -1 else a * -1

def sum_n(n):
    return n * (n+1) // 2

# print(sum_n(100))
# print(sum_n(11))
# print(sum_n(8))

# print(abs(-1111))
# print(abs(34124))

def swap(a,b):
    a,b = b,a
    return a,b

a,b = 80,90
print(type(swap(a,b)), a,b)