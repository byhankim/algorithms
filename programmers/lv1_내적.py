# 20. 12. 10. 내적
def solution(a, b):
    answer = 0
    for x, y in zip(a,b):
        answer += x*y
    return answer