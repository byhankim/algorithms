# 2021. 1. 1 30초컷 칭찬해~
def solution(x):
    return not x % sum(list(map(int, str(x))))