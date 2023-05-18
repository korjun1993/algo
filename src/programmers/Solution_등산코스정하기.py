from collections import defaultdict, deque

inf = 10000001


def bfs(start, graph, n):
    global inf
    cand_intensity = inf
    time = [inf] * (n + 1)
    time[start] = 0
    q = deque()
    q.append([start, 0])
    while q:
        idx, w = q.popleft()
        if idx in gates:
            cand_intensity = min(cand_intensity, w)
            continue
        for nextidx, nextw in graph[idx].items():색
            w = max(time[idx], nextw)
            if w < time[nextidx] and nextidx not in summits:
                time[nextidx] = w
                q.append([nextidx, w])

    return cand_intensity


def solution(n, paths, gates, summits):
    graph = [defaultdict() for _ in range(n + 1)]
    intensity = [10000001] * (n + 1)
    for x, y, w in paths:
        graph[x][y] = w
        graph[y][x] = w
    for gate in gates:
        q = deque()

n = 6
paths = [[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]
gates = [1, 3]
summits = [5]
print(solution(n, paths, gates, summits))