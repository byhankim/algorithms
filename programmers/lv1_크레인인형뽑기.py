# 2020. 12. 2. 크레인 인형뽑기
def solution(board, moves):
    stack = []
    cnt = 0
    for m in moves:
        for b in board:
            if b[m-1] == 0: continue
            if stack and stack[-1] == b[m-1]:
                cnt += 2
                del stack[-1]
            else:
                stack.append(b[m-1])
            b[m-1] = 0
            break
    return cnt