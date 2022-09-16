dy = [0, 1, 0, -1]
dx = [-1, 0, 1, 0]
ty = [[0, -1, 1, -2, -1, 1, 2, -1, 1],
      [2, 1, 1, 0, 0, 0, 0, -1, -1],
      [0, -1, 1, -2, -1, 1, 2, -1, 1],
      [-2, -1, -1, 0, 0, 0, 0, 1, 1]]
tx = [[-2, -1, -1, 0, 0, 0, 0, 1, 1],
      [0, -1, 1, -2, -1, 1, 2, -1, 1],
      [2, 1, 1, 0, 0, 0, 0, -1, -1],
      [0, 1, -1, 2, 1, -1, -2, 1, -1]]
v = [5, 10, 10, 2, 7, 7, 2, 1, 1]
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
cur = (N // 2, N // 2, 0)
answer = 0
for i in range(N * 2 - 1):
    # 거리계산
    dis = i // 2 + 1 if i != N * 2 - 2 else dis
    for _ in range(dis):
        # 토네이도의 도착점 계산
        y, x, d = cur
        ny, nx = y + dy[d], x + dx[d]
        # 모래가 흩어지는 양 계산
        origin = board[ny][nx]
        for j in range(9):
            nny, nnx, = ny + ty[d][j], nx + tx[d][j]
            s = int(origin / 100 * v[j])
            board[ny][nx] -= s
            if 0 <= nny < N and 0 <= nnx < N:
                board[nny][nnx] += s
            else:
                answer += s
        # Alpha 계산
        nny, nnx = ny + dy[d], nx + dx[d]
        if 0 <= nny < N and 0 <= nnx < N:
            board[nny][nnx] += board[ny][nx]
        else:
            answer += board[ny][nx]
        board[ny][nx] = 0
        cur = ny, nx, d
    cur = (ny, nx, (d + 1) % 4)
print(answer)