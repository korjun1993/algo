n, k = map(int, input().split())
p = list(map(int, input().split()))
ans = 0
r = sum(p)
l = 0
while l <= r:
    mid = (l + r) // 2
    score = 0
    group = 0
    for i in range(n):
        score += p[i]
        if score >= mid:
            score = 0
            group += 1
    if group < k:
        r = mid - 1
    else:
        l = mid + 1

print(r)