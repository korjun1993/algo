n, m = map(int, input().split())
selected = [0] * n


def solve(k):
    if k == m:
        for i in range(m):
            print(selected[i], end=' ')
        print()
        return

    for i in range(1, n + 1):
        selected[k] = i
        solve(k + 1)
        selected[k] = 0


solve(0)