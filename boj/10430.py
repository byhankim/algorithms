# 21. 1. 8. [BR5] 10430. 나머지
# f-string 연습해봄
A, B, C = map(int, input().split())
print(f"{(A+B)%C}\n{((A%C)+(B%C))%C}\n{(A*B)%C}\n{((A%C)*(B%C))%C}")