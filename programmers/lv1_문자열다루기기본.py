# 20. 12. 08
def solution(s):
    if (len(s) == 4 or len(s) == 6) and s.isdecimal():
        return True
    else:
        return False
    # 한줄
    # return s.isdecimal() and len(s) in (4,6)