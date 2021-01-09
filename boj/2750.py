# 21.01.09 [br1] 2750. 수 정렬하기
N = int(input())
nums = [int(input()) for _ in range(N)]
for n in sorted(nums):
    print(n)