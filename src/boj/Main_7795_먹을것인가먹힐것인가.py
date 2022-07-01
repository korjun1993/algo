def lowerBound(limit, array):
    L = 0
    R = len(array) - 1
    V = -1
    while L <= R:
        M = (L + R) // 2
        if array[M] < limit:
            L = M + 1
            V = M
        else:
            R = M - 1

    return V + 1


# solve promblem
T = int(input())
for _ in range(T):
    result = 0
    N, M = map(lambda x: int(x), input().split())
    A = list(map(lambda x: int(x), input().split()))
    B = sorted(list(map(lambda x: int(x), input().split())))
    for a in A:
        result += lowerBound(a, B)
    print(result)
