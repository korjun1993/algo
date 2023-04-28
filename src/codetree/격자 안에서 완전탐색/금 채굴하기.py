n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]


def do(r, c, k):
    gold = 0
    visit = [[False] * n for _ in range(n)]
    visit[r][c] = True
    q = [(r, c, 0)]

    while q:
        r, c, dis = q.pop(0)
        gold += int(board[r][c])
        for d in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nr = r + d[0]
            nc = c + d[1]
            if nr >= n or nc >= n or nr < 0 or nc < 0:
                continue
            if visit[nr][nc]:
                continue
            if dis + 1 > k:
                continue
            visit[nr][nc] = True
            q.append((nr, nc, dis + 1))

    return gold


answer = 0

for i in range(n):
    for j in range(n):
        for k in range(n):
            cost = k ** 2 + (k + 1) ** 2
            gold = do(i, j, k)
            if cost <= gold * m:
                answer = max(answer, gold)

print(answer)
