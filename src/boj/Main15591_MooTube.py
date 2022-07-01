from collections import deque
from sys import stdin

# input
read = stdin.readline
N, Q = map(lambda x: int(x), read().split())
adj = [[] for _ in range(N + 1)]
usa = [[1000000000] * (N + 1) for _ in range(N + 1)]


def bfs(start):
    q = deque()
    visit = [False] * (N + 1)
    visit[start] = True
    q.append(start)
    while q:
        x = q.popleft()
        for y in adj[x]:
            if not visit[y[0]]:
                visit[y[0]] = True
                usa[start][y[0]] = min(usa[start][x], y[1])
                q.append(y[0])


for _ in range(N - 1):
    p, q, r = map(lambda x: int(x), read().split())
    adj[p].append((q, r))
    adj[q].append((p, r))

question = [tuple(list(map(lambda x: int(x), read().split()))) for _ in range(Q)]

for start in range(1, N + 1):
    bfs(start)

for q in question:
    n = 0
    k = q[0]
    v = q[1]
    for r in usa[v]:
        if r >= k and r != 1000000000:
            n += 1
    print(n)
