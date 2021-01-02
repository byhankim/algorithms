# 21. 1. 2. 행렬의 덧셈
# 넘파이로 한줄컷 가능했지만 다른풀이 도출하는데 꽤 시간이 걸렸다
# 의외로 list comprehension이 가장 빨랐다

import numpy as np

def solution_numpy(arr1, arr2):
    return np.add(np.array(arr1), np.array(arr2)).tolist()

def solution_map(arr1, arr2):
    ans = []
    for i in range(len(arr1)):
        a = list(map(sum, zip(arr1[i],arr2[i])))
        ans.append(a)
    return ans

# fastest
def solution_lc_zip(arr1, arr2):
    return [[x+y for x,y in zip(a1,a2)] for a1, a2 in zip(arr1, arr2)]