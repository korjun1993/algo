n, m = map(int, input().split())
a = list(map(int, input().split()))
selected = [0] * (m + 1)
a.sort()


# a[k] ~ a[n] 까지 고르는 함수
def solve(k):
    if k == m + 1:
        for i in range(1, m + 1):
            print(a[selected[i]], end=' ')
        print()
        return

    for i in range(selected[k - 1], n):
        selected[k] = i
        solve(k + 1)
        selected[k] = 0


solve(1)
