# 2020. 12. 07
def solution(strings, n):
    return sorted(strings, key=lambda x: (x[n], x)) # key 튜플로 return 가능