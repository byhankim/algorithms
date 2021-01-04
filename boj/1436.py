# [BF]1436. 영화감독 숌
# 무슨 문제인지 계속 감을 못 잡다가 질문글 보고 이해함
# 1. 1씩 increment하면서 666이 들어가는 숫자만 리스트에 추가하고 정렬한 다음
# 맨 마지막 값만 출력하는 방식으로 풀었음
# 2. 굳이 리스트 쓸 필요 없어보여서 없엠
# 80ms 대도 있는걸로 봐서 좀더 효율적인 답을 생각해보자

# 29328kb, 920ms
def solution_with_list():
    N = int(input())   
    num = 1
    cnt = 0
    numbers = []
    while cnt < N:
        num += 1
        if '666' in str(num):
            cnt += 1
            numbers.append(num)
    print(numbers[-1])

# 29076kb, 924ms
def solution_without_list():
    N = int(input())
    num = 665
    cnt = 0
    while cnt < N:
        num += 1
        if '666' in str(num):
            cnt += 1
    print(num)