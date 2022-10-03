maps = [list(input()) for _ in range(5)]
vis = [False] * (1 << 25)
ans = 0


def solve(state, k, s):
    global ans

    # back tracking
    if vis[state]: return
    vis[state] = True

    if k == 7:  # base condition
        ans += 1 if s >= 4 else 0
        return

    # search
    for i in range(25):
        if not state & (1 << i):
            continue
        for dx, dy in [[0, -1], [0, 1], [-1, 0], [1, 0]]:
            nx = i % 5 + dx
            ny = i // 5 + dy
            if 0 <= nx < 5 and 0 <= ny < 5:
                solve(state | 1 << (nx + 5 * ny), k + 1, s + 1 if maps[ny][nx] == 'S' else s)


for i in range(5):
    for j in range(5):
        if maps[i][j] == 'S':
            solve(1 << (5 * i + j), 1, 1)
print(ans)