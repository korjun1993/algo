arr = []
selected = [0] * 7
used = [False] * 101

for _ in range(9):
    arr.append(int(input()))


def solve(k):
    if k == 7:
        if sum(selected) == 100:
            selected.sort()
            for i in range(7):
                print(selected[i])
            quit()
        return
    for i in range(9):
        if used[arr[i]]:
            continue
        used[arr[i]] = True
        selected[k] = arr[i]
        solve(k + 1)
        used[arr[i]] = False
        selected[k] = 0

solve(0)
