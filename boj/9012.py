# 21-01-06. [9012]괄호
# 자꾸 런타임 에러가 뜬다 
#   -> stack pop할때 빈 스택인지 예외처리 필수
#   -> integer를 for-loop에서 range로 안돌려서 났던 에러
N = int(input())
for _ in range(N):
    s = input()
    stack = []
    for c in s:
        if c == '(':
            stack.append('(')
            continue
        if len(stack):
            stack.pop()
        else:
            stack.append('-1')
            break
    res = "YES" if not len(stack) else "NO"
    print(res)