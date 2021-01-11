# 21.01.11 [BR2] 2798 블랙잭
# 28766kb, 76ms
# curr 변수를 미리 선언해놓는게 4ms 더 빨랐다
N, M = map(int, input().split())
cards = sorted(list(map(int, input().split())))[::-1]
curr, best = 0, 0
for i in range(len(cards)-2):
    if cards[i] > M: continue
    for j in range(1, len(cards)-1):
        if j == i: continue
        if cards[i]+cards[j] > M: continue
        for k in range(2, len(cards)):
            if k == i or k == j: continue
            curr = cards[i]+cards[j]+cards[k]
            if curr > M: continue
            if curr > best:
                best = curr
            break
print(best)