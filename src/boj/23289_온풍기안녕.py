from copy import deepcopy

r, c, k = map(int, input().split())  # 세로, 가로, 조사하는 모든 칸의 온도 목표점
a = [[0] * c for _ in range(r)]  # 격자판 온도
b = [list(map(int, input().split())) for _ in range(r)]  # 격자판
h = []  # 온풍기 정보
w = int(input())  # 벽의 수
wt = [list(map(int, input().split())) for _ in range(w)]  # 벽 입력 정보
wi = [[[[True] * c for _ in range(r)] for _ in range(c)] for _ in range(r)]  # 벽 정보
ti = []  # 조사하는 칸 정보
dx = [[], [-1, 0, 1], [-1, 0, 1], [-1, -1, -1], [1, 1, 1]]
dy = [[], [1, 1, 1], [-1, -1, -1], [-1, 0, 1], [-1, 0, 1]]
vis = [[False] * c for _ in range(r)]
ans = 0


# 필요한 정보 초기화
def init():
    global r, c
    for i in range(r):
        for j in range(c):
            if b[i][j] == 1:
                h.append((i, j + 1, b[i][j]))
            elif b[i][j] == 2:
                h.append((i, j - 1, b[i][j]))
            elif b[i][j] == 3:
                h.append((i - 1, j, b[i][j]))
            elif b[i][j] == 4:
                h.append((i + 1, j, b[i][j]))
            elif b[i][j] == 5:
                ti.append((i, j))

    for x, y, t in wt:
        if t == 0:
            wi[x - 1][y - 1][x - 2][y - 1] = False
            wi[x - 2][y - 1][x - 1][y - 1] = False
        elif t == 1:
            wi[x - 1][y - 1][x - 1][y] = False
            wi[x - 1][y][x - 1][y - 1] = False


# 방향이 d인 바람이 (x, y) => (nx, ny) 향할때, 벽에 의해 가로막히진 않는지?
def isvalid(x, y, i, d):
    if d == 1:
        if i == 0:
            return wi[x][y][x - 1][y] and wi[x - 1][y][x - 1][y + 1]
        elif i == 1:
            return wi[x][y][x][y + 1]
        elif i == 2:
            return wi[x][y][x + 1][y] and wi[x + 1][y][x + 1][y + 1]
    elif d == 2:
        if i == 0:
            return wi[x][y][x - 1][y] and wi[x - 1][y][x - 1][y - 1]
        elif i == 1:
            return wi[x][y][x][y - 1]
        elif i == 2:
            return wi[x][y][x + 1][y] and wi[x + 1][y][x + 1][y - 1]
    elif d == 3:
        if i == 0:
            return wi[x][y][x][y - 1] and wi[x][y - 1][x - 1][y - 1]
        elif i == 1:
            return wi[x][y][x - 1][y]
        elif i == 2:
            return wi[x][y][x][y + 1] and wi[x][y + 1][x - 1][y + 1]
    elif d == 4:
        if i == 0:
            return wi[x][y][x][y - 1] and wi[x][y - 1][x + 1][y - 1]
        elif i == 1:
            return wi[x][y][x + 1][y]
        elif i == 2:
            return wi[x][y][x][y + 1] and wi[x][y + 1][x + 1][y + 1]


# 방향이 d이고, 온도가 v인 바람이 (x, y) 좌표의 온도를 올리는 함수
def wind(x, y, d, t):
    global r, c, k

    if vis[x][y] or t < 1:
        return

    vis[x][y] = True
    a[x][y] += t

    for i in range(3):
        nx = x + dx[d][i]
        ny = y + dy[d][i]
        if 0 <= nx < r and 0 <= ny < c and not vis[nx][ny] and isvalid(x, y, i, d):  # 칸이 존재하지 않는다면, 바람은 이동하지 않는다.
            wind(nx, ny, d, t - 1)


# 온도를 조절하는 함수
# 모든 인접한 칸에 대해서, 온도가 높은 칸에서 낮은 칸으로 [(두 칸의 온도 차이) // 4] 만큼 온도가 조절된다.
# 온도가 높은 칸 - 온도가 낮은 칸 +
# 인접한 두 칸 사이에 벽이 있는 경우에는 온도가 조절되지 않는다.
def regulate():
    global r, c
    na = deepcopy(a)
    for i in range(r):
        for j in range(c):
            for di, dj in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                ni = i + di
                nj = j + dj
                if 0 <= ni < r and 0 <= nj < c and wi[i][j][ni][nj] and a[i][j] > a[ni][nj]:
                    temp = (a[i][j] - a[ni][nj]) // 4
                    na[i][j] -= temp
                    na[ni][nj] += temp
    return na


# 3. 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
# 온도가 0인 칸은 온도가 감소하지 않는다.
def decrease():
    global r, c
    for i in range(c):
        if a[0][i] > 0:
            a[0][i] -= 1
        if a[r - 1][i] > 0:
            a[r - 1][i] -= 1

    for i in range(1, r - 1):
        if a[i][0] > 0:
            a[i][0] -= 1
        if a[i][c - 1] > 0:
            a[i][c - 1] -= 1
    return a


def check():
    global k
    for x, y in ti:
        if a[x][y] < k:
            return False
    return True


# solve start
init()

while True:
    for rw, cl, d in h:
        wind(rw, cl, d, 5)
        vis = [[False] * c for _ in range(r)]
    a = regulate()
    a = decrease()
    ans += 1
    if check() or ans >= 101:
        print(ans)
        break
