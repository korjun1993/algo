import sys

read = sys.stdin.readline


def bsearch(A, b):
    L = 0
    R = len(A) - 1

    while L <= R:
        M = (L + R) // 2
        if A[M] < b:
            L = M + 1
        elif A[M] == b:
            return True
        else:
            R = M - 1

    return False


N = int(read())
A = list(map(lambda x: int(x), read().split()))
M = int(read())
B = list(map(lambda x: int(x), read().split()))

A.sort()
for b in B:
    print('1' if bsearch(A, b) else '0')
