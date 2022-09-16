import copy

answer = 0
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]
N, M, K = map(int, input().split())
board = [[[] for _ in range(N)] for _ in range(N)]

for _ in range(M):
    y, x, m, s, d = map(int, input().split())
    y -= 1
    x -= 1
    board[y][x].append([m, s, d])

while K > 0:
    K -= 1
    nboard = [[[] for _ in range(N)] for _ in range(N)]
    for r in range(N):
        for c in range(N):
            for f in board[r][c]:
                m, s, d = f
                nr = (r + s * dr[d]) % N
                nc = (c + s * dc[d]) % N
                nboard[nr][nc].append([m, s, d])

    for r in range(N):
        for c in range(N):
            n = len(nboard[r][c])
            if n >= 2:
                nm = sum([f[0] for f in nboard[r][c]]) // 5
                ns = sum([f[1] for f in nboard[r][c]]) // n
                same = True
                for i in range(n - 1):
                    if nboard[r][c][i][2] % 2 != nboard[r][c][i + 1][2] % 2:
                        same = False
                nboard[r][c].clear()
                if nm > 0:
                    nd = [0, 2, 4, 6] if same else [1, 3, 5, 7]
                    for i in range(4):
                        nboard[r][c].append([nm, ns, nd[i]])
            if K == 0:
                answer += sum([f[0] for f in nboard[r][c]])
    board = nboard

print(answer)