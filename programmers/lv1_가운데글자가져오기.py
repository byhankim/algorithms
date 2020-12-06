# 2020. 12. 6. lv1 - 가운데 글자 가져오기
def solution(s):
    i = len(s)//2
    return s[i] if len(s) % 2 else s[i-1:i+1]