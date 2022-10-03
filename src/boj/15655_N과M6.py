n, m = map(int, input().split())
a = list(map(int, input().split()))
selected = [-1] * (m + 1)
used = [False] * 10001


def solve(k):
    # base condition
    if k == m + 1:
        for i in range(1, m + 1):
            print(selected[i], end=" ")
        print()
        return

    # search

    for i in range(n):
        # back-tracking
        if used[a[i]] or a[i] <= selected[k - 1]:
            continue
        selected[k] = a[i]
        used[a[i]] = True
        solve(k + 1)
        selected[k] = -1
        used[a[i]] = False


a.sort()
solve(1)
