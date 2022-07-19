N, C = map(int, input().split())
X = [int(input()) for _ in range(N)]
answer = 0
X.sort()
l = 1
r = X[N - 1] - X[0]


def determination(length):
    cnt = 1
    l = 0
    for r in range(1, len(X)):
        if X[r] - X[l] >= length:
            cnt += 1
            l = r
        if cnt == C:
            return True
    return False


while l <= r:
    m = (l + r) // 2
    if determination(m):
        l = m + 1
        answer = m
    else:
        r = m - 1

print(answer)