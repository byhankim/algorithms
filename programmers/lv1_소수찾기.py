def solution_bf(n):
    cnt = 0
    flag = False                        
    for i in range(2, n+1):
        # print("i:",i,end='')
        flag = True
        for j in range(2, i):
            if i % j == 0:
                flag = False
                break
        if flag: cnt += 1
        # print(" prime number" if flag else " not prime")
    return cnt

def solution_bf_sqrt(n):
    n = n+1
    cnt = 0
    flag = False
    for i in range(2, n):
        flag = True
        for j in range(2, int(i**1/2)+1):
            if i % j == 0:
                flag = False
                break
        if flag: cnt += 1
    return cnt

def solution(n):
    n += 1
    prime = [0]*(n+1)
    