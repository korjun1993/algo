from sys import stdin

read = stdin.readline

N = int(read())
A = list(map(lambda x: int(x), read().split()))
V1 = V2 = 0
Min = 2000000000


def lower_bound(L, R, X):
    V = R + 1
    while L <= R:
        M = (L + R) // 2
        if A[M] < X:
            L = M + 1
        else:
            R = M - 1
            V = M
    return V


# problem solve
A.sort()
for left in range(N):
    cand = lower_bound(left + 1, N - 1, -A[left])
    if left + 1 <= cand - 1 and abs(A[cand - 1] + A[left]) < Min:
        Min = abs(A[cand - 1] + A[left])
        V1 = A[left]
        V2 = A[cand - 1]

    if cand < N and abs(A[cand] + A[left]) < Min:
        Min = abs(A[cand] + A[left])
        V1 = A[left]
        V2 = A[cand]

print(V1, " ", V2)
