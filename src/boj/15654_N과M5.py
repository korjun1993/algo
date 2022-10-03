n, m = map(int, input().split())
a = list(map(int, input().split()))
selected = [0] * m
used = [False] * 10001


def solve(k):
    # base condition
    if k == m:
        for i in range(m):
            print(selected[i], end=" ")
        print()
        return

    # search
    for i in range(n):
        # back-tracking
        if used[a[i]]:
            continue
        selected[k] = a[i]
        used[a[i]] = True
        solve(k + 1)
        selected[k] = 0
        used[a[i]] = False


a.sort()
solve(0)
