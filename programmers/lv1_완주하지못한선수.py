# 2020. 12. 3. 완주하지 못한 선수
def solution(participant, completion):
    participant.sort()
    completion.sort()
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    return participant[-1]



# 모범답안 풀이(w/ collections.Counter)
# ---------------------------------------------------------------------------------------
import collections

def solution2(participant, completion):
    return list(collections.Counter(participant) - collections.Counter(completion))[0]
# ---------------------------------------------------------------------------------------


print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))
print(solution2(["leo", "kiki", "eden"], ["eden", "kiki"]))