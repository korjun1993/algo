dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
cmd = [list(map(int, input().split())) for _ in range(m)]
cloud = [[n - 2, 0], [n - 2, 1], [n - 1, 0], [n - 1, 1]]
visit = [[False] * n for _ in range(n)]
answer = 0
for d, s in cmd:
    next = []
    for y, x in cloud:
        ny = (y + dy[d - 1] * s) % n
        nx = (x + dx[d - 1] * s) % n
        board[ny][nx] += 1
        next.append([ny, nx])
        visit[ny][nx] = True
    for y in range(n):
        for x in range(n):
            for i in [1, 3, 5, 7]:
                if not visit[y][x]:
                    continue
                ny = y + dy[i]
                nx = x + dx[i]
                if ny < 0 or nx < 0 or ny >= n or nx >= n or board[ny][nx] == 0:
                    continue
                board[y][x] += 1
    cloud = []
    for y in range(n):
        for x in range(n):
            if board[y][x] < 2 or visit[y][x]:
                visit[y][x] = False
                continue
            board[y][x] -= 2
            cloud.append([y, x])

for arr in board:
    answer += sum(arr)
print(answer)