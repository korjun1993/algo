import heapq

dy = (-1, 1, 0, 0)
dx = (0, 0, -1, 1)


def bfs():
    q = []
    visit = [[False] * N for _ in range(N)]
    heapq.heappush(q, (0, 0, 0))
    visit[0][0] = True
    while q:
        c, y, x = heapq.heappop(q)
        if x == N - 1 and y == N - 1:
            return c
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or ny >= N or nx < 0 or nx >= N or visit[ny][nx]:
                continue
            nc = c + 1 if map[ny][nx] == '0' else c
            heapq.heappush(q, (nc, ny, nx))
            visit[ny][nx] = True


N = int(input())
map = [list(input()) for _ in range(N)]
ans = bfs()
print(ans)
