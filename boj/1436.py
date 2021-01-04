# [BF]1436. 영화감독 숌
# 29328kb, 916ms
# 무슨 문제인지 계속 감을 못 잡다가 질문글 보고 이해함
# 1씩 increment하면서 666이 들어가는 숫자만 리스트에 추가하고 정렬한 다음
# 맨 마지막 값만 출력하는 방식으로 풀었음
# 80ms 대도 있는걸로 봐서 좀더 효율적인 답을 생각해보자
N = int(input())
num = 1
cnt = 0
numbers = []
while cnt < N:
    num += 1
    if '666' in str(num):
        cnt += 1
        numbers.append(num)
numbers = sorted(numbers)
print(numbers[-1])