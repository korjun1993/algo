from collections import deque

n, q = map(int, input().split())
m = 2 ** n
b = [list(map(int, input().split())) for _ in range(m)]
l = [*map(int, input().split())]
v = [[False] * m for _ in range(m)]


# 파이어스톰
# 2^L x 2^L 크기의 부분 격자로 나눈다.
# N = 3이면 길이가 8인 배열이므로, L = 1이면 격자의 시작 위치를 다음처럼 쪼갤 수 있음.
# (0,0), (0,2), (0,4), (0,6)
# (2,0), (2.2), (2,4), (2,6)
# (4,0), (4,2), (4,4), (4,6)
# (6,0), (6,2), (6,4), (6,6)
# 모든 격자를 시계 방향으로 90도 회전시킨다.
# 얼음이 잇는 인접한 칸 수를 구한다.
# 2개 이하라면 얼음의 양이 1 줄어든다.
def rotate(b, i, j, l):
    nb = [b[r][j:j + l] for r in range(i, i + l)]
    nb = [list(a) for a in zip(*reversed(nb))]
    for r in range(l):
        for c in range(l):
            b[i + r][j + c] = nb[r][c]
    return b


def fs(b, l):
    global m
    for i in range(m)[::l]:
        for j in range(m)[::l]:
            b = rotate(b, i, j, l)

    ll = []
    for r in range(m):
        for c in range(m):
            cnt = 0
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr = r + dr
                nc = c + dc
                if nr < 0 or nc < 0 or nr >= m or nc >= m or b[nr][nc] == 0:
                    cnt += 1
            if cnt >= 2 and b[r][c]:
                ll.append([r, c])

    for r, c in ll:
        b[r][c] -= 1

    return b


# 얼음이 있는 칸이 얼음이 있는 칸과 인접해 있으면, 두 칸을 연결되어 있다고 한다.
# 덩어리는 연결된 칸의 집합이다.
# 가장 큰 덩어리가 차지하는 칸의 개수를 구해라.
def bfs(b, i, j):
    global m, v
    w = 0
    v[i][j] = True
    q = deque()
    q.append([i, j])
    while q:
        r, c = q.popleft()
        for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nr = r + dr
            nc = c + dc
            if 0 <= nr < m and 0 <= nc < m and not v[nr][nc] and b[nr][nc] > 0:
                v[nr][nc] = True
                q.append([nr, nc])
                w += 1
    return w + 1 if w > 0 else 0


# 남아 있는 얼음의 합을 출력한다.
# 가장 큰 덩어리가 차지하는 칸의 개수를 출력한다.
def ans(b):
    global m, v
    s = 0
    w = 0
    for i in range(m):
        for j in range(m):
            s += board[i][j]
            if not v[i][j] and b[i][j] > 0:
                w = max(w, bfs(b, i, j))
    return s, w


for i in range(len(l)):
    board = fs(b, 2 ** l[i])
s, w = ans(b)
print(f'{s}\n{w}')
