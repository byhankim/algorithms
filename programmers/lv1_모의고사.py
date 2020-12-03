def solution(answers):
    answer = [0] * 3
    res = []
    a1 = [1,2,3,4,5]
    a2 = [2,1,2,3,2,4,2,5]
    a3 = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        if answers[i] == a1[i % len(a1)]:
            answer[0] += 1
        if answers[i] == a2[i % len(a2)]:
            answer[1] += 1
        if answers[i] == a3[i % len(a3)]:
            answer[2] += 1
    for k, v in enumerate(answer):
        if v == max(answer):
            res.append(k+1)
    return res