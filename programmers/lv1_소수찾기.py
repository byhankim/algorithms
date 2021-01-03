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

# 3. field
# 0,1을 제외한 모든 수가 소수라고 가정하고
# 해당 수가 소수라면 그 수를 제외한 모든 배수를 합성수 판정한다
def solution(n):
    prime = [True]*(n+1)
    for i in range(2,n+1):
        if prime[i]:
            for j in range(i+i, n+1, i):
                prime[j] = 0
    return sum(prime)-2

print(solution(10))
print(solution(5))
print(solution(2))
print(solution(999999))