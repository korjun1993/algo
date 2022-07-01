from itertools import combinations

# input
answer = 0
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
N, K, R = map(lambda x: int(x), input().split())
visit = [[False] * (N + 1) for _ in range(N + 1)]
road = [[[] for _ in range(N + 1)] for _ in range(N + 1)]

for _ in range(R):
    r1, c1, r2, c2 = map(lambda x: int(x), input().split())
    road[r1][c1].append((r2, c2))
    road[r2][c2].append((r1, c1))
cows = [tuple(list(map(lambda x: int(x), input().split()))) for _ in range(K)]


# dfs function
def dfs(r1, c1, r2, c2):
    if (r1, c1) == (r2, c2):
        global answer
        answer -= 1
        return

    for i in range(4):
        nr = r1 + dy[i]
        nc = c1 + dx[i]
        if 0 < nr <= N and 0 < nc <= N and not visit[nr][nc] and (nr, nc) not in road[r1][c1]:
            visit[nr][nc] = True
            dfs(nr, nc, r2, c2)


# problem solve
comb = list(combinations(cows, 2))
for x in comb:
    answer += 1
    visit[x[0][0]][x[0][1]] = True
    dfs(x[0][0], x[0][1], x[1][0], x[1][1])
    visit = [[False] * (N + 1) for _ in range(N + 1)]

print(answer)
