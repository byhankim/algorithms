def solution(s):
    ss = list(s.split(' ')) # 공백이 2개 이상일 때 별개로 나뉜다. s.split()은 틀림!
    ans = ""
    for w in ss:
        word = ""
        for i in range(0, len(w)):
            word += w[i].upper() if i % 2 == 0 else w[i].lower()
        ans += word.strip() + ' '
    return ans[:-1]