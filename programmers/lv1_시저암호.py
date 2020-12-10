def solution(s, n):
    answer = ''
    for c in s:
        if c.isupper():
            answer += chr(ord('A') + (ord(c)-ord('A')+n) % 26)
        elif c.islower():
            answer += chr(ord('a') + (ord(c)-ord('a')+n) % 26)
        else:
            answer += ' '
    return answer