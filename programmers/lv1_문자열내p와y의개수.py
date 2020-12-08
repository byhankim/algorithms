# 20. 12. 8
def solution(s):
    cnt = 0
    for c in s.lower():
        if c == 'p': cnt += 1
        elif c == 'y': cnt -= 1
    return False if cnt else True