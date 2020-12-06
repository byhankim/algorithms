# 2020. 12. 5. lv1 - 체육복
def solution(n, lost, reserve): 
    lost.sort()
    reserve.sort()
    cnt = 0
    for i in range(1, n+1):
        if i in lost and i in reserve:
            lost.remove(i)
            reserve.remove(i)
    for l in lost:
        if l-1 in reserve:
            cnt += 1
            reserve.remove(l-1)
        elif l+1 in reserve:
            cnt += 1
            reserve.remove(l+1)
    return n - len(lost) + cnt