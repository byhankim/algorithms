# 2020. 12. 07. 두 정수 사이의 합
def solution(a, b):
    if a>b: a, b = b, a
    return sum([x for x in range(a,b+1)])