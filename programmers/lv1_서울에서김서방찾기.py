# 20. 12. 08
def solution(seoul):
    for i in range(len(seoul)):
        if "Kim" == seoul[i]:
            return "김서방은 " + str(i) + "에 있다"
    
# 한 줄 풀이 (꾸준히 위 답안보다 빠름)
# def sol(seoul):
#     return f'김서방은 {seoul.index("Kim")}에 있다'