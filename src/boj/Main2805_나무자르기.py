N, M = map(int, input().split())
T = list(map(int, input().split()))
T.sort()
l = 0
r = T[N - 1]
answer = 0

# 가져갈 나무의 길이 총합이 M 이상을 만족시킬 때, 절단기 길이의 가장 큰 값을 반환
while l <= r:
    mid = (l + r) // 2
    v = sum(t - mid for t in T if t - mid > 0)
    if v < M:  # 나무 수확량이 작을수록, m의 값을 작게해야함.
        r = mid - 1
    elif v >= M:
        l = mid + 1
        answer = mid

print(answer)
