n, m = map(int, input().split())
a = list(map(int, input().split()))
a.sort()
selected = []


def solve(k):
    if k == m:
        for num in selected:
            print(num, end=' ')
        print()
        return
    for num in a:
        selected.append(num)
        solve(k + 1)
        selected.pop()


solve(0)
