from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
ans = 0


# 검은색 블록은 포함되면 안된다.
# 무지개 블록은 상관없다.
# 블록의 개수는 2 이상
# 기준 블록: 무지개 X, 행,열 번호가 가장 작은 것
# return (기준블록, 크기, 무지개블록 수, 그룹원소)
def bfs(row, col):
    size = 1
    zero = []
    list = []
    visit[row][col] = True
    q = deque()
    q.append((row, col))
    list.append((row, col))
    while q:
        r, c = q.pop()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if nr < 0 or nc < 0 or nr >= N or nc >= N or visit[nr][nc]:
                continue
            if board[nr][nc] == 0 or board[nr][nc] == board[row][col]:
                size += 1
                visit[nr][nc] = True
                q.append((nr, nc))
                list.append((nr, nc))
                if board[nr][nc] == 0:
                    zero.append((nr, nc))

    # 다른 색깔도 무지개색으로 방문이 가능하게.
    sizezero = len(zero)
    for r, c in zero:
        visit[r][c] = False

    return [size, sizezero, list]


# 기준: 크기 > 무지개 블록수 > 기준 블록의 행,열이 클수록
def maxcheck(maxgroup, candgroup):
    if maxgroup[0] != candgroup[0]:
        return maxgroup[0] <= candgroup[0]
    else:
        return maxgroup[1] <= candgroup[1]


def deleteblock(maxgroup):
    for r, c in maxgroup[2]:
        board[r][c] = -2
    return maxgroup[0] ** 2


def move():
    for i in range(N):
        for j in range(N - 1)[::-1]:
            if board[j][i] > -1:
                k = j
                while k < N - 1 and board[k + 1][i] == -2:
                    k += 1
                if k > j:
                    board[k][i] = board[j][i]
                    board[j][i] = -2



def rotate():
    global board
    tmp = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            tmp[N - 1 - j][i] = board[i][j]
    board = tmp


while True:
    visit = [[False] * N for _ in range(N)]
    maxgroup = [0, 0, []]
    for i in range(N):
        for j in range(N):
            if board[i][j] > 0 and not visit[i][j]:
                candgroup = bfs(i, j)
                # 크기가 가장 큰 블록 그룹을 찾는다.
                if maxcheck(maxgroup, candgroup):
                    maxgroup = candgroup

    # 그룹에 속한 블록의 개수는 2보다 크거나 같아야 한다.
    if maxgroup[0] >= 2:
        # 블록을 모두 제거한다. 블록수^2을 획득한다.
        ans += deleteblock(maxgroup)
        # 중력(검정블록 제외)-회전-중력을 적용한다.
        for i in range(N):
            for j in range(N):
                print(board[i][j], end= '  ')
            print()
        print()
        move()
        for i in range(N):
            for j in range(N):
                print(board[i][j], end= '  ')
            print()
        print()
        rotate()
        move()
    else:
        print(ans)
        break