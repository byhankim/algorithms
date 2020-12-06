# 2020. 12. 6. lv1 - 같은숫자는싫어
# 문제 잘못읽어서 몇 시간 허비ㅠ
def solution(arr):
    answer = [-1]
    for i in arr:
        if i != answer[-1]:
            answer.append(i)
    return answer[1:]