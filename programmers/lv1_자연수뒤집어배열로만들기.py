# 20. 12. 17
# return list(map(int, reversed(str(n))))도 있다
def solution(n):
   return [int(i) for i in str(n)][::-1]