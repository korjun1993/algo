import sys

read = sys.stdin.readline
n, k = map(int, read().split())
x = list(int(read()) for _ in range(n))
x.sort()


def determine(t):
    global k
    sum = 0
    for i in x:
        if i < t:
            sum += t - i
    return sum <= k


l = x[0]
r = x[n - 1] + k
ans = x[0]
while l <= r:
    m = (l + r) // 2
    if determine(m):
        ans = m
        l = m + 1
    else:
        r = m - 1
print(ans)
