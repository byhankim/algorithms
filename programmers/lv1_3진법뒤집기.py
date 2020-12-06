# 2020. 12. 6. lv1 - 3진법 뒤집기
def solution(n):
    tmp = ''

    while n:
        n, m = divmod(n, 3)
        tmp += str(m)

    tmp = str(int(tmp))
    n = 0

    for i in range(len(tmp)):
        n += int(tmp[len(tmp)-i-1]) * (3 ** i)

    return n