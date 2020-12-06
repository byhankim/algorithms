# 2020. 12. 6. lv1 - 2016년
def solution(a, b):
    offset = 5
    months = [31,29,31,30,31,30,31,31,30,31,30,31]
    answer = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    date = sum(months[:a-1]) + b
    return answer[(date % 7 + offset) % 7 -1]