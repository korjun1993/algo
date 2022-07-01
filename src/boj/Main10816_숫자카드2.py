import sys
import bisect


def bsearch(arr, x):
    L = 0
    R = len(arr) - 1
    while L <= R:
        M = (L + R) // 2
        if A[M] < x:
            L = M + 1
        elif A[M] == x:
            return True
        else:
            R = M - 1
    return False


read = sys.stdin.readline

N = int(read())
A = list(map(lambda x: int(x), read().split()))
M = int(read())
B = list(map(lambda x: int(x), read().split()))

A.sort()

for b in B:
    result = 0
    if bsearch(A, b):
        L = bisect.bisect_left(A, b)
        R = bisect.bisect_right(A, b)
        result = R - L
    print(result)