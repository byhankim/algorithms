# 2020. 12. 07. lv1 - 나누어 떨어지는 숫자 배열
def solution(arr, divisor):
    answer = [n for n in arr if not n % divisor]
    return sorted(answer) if len(answer) else [-1]