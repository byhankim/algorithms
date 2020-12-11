# 2020. 12. 11. 약수의 합
def solution(n):
    return sum([x for x in range(1, n+1) if not n % x])