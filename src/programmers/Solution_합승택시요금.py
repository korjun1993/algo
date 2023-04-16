from heapq import heappush, heappop
from collections import deque


def dijkstra(graph, start, size):
    inf = 10 ** 5
    dist = [inf] * size
    dist[start] = 0
    pq = []
    heappush(pq, [0, start])
    while pq:
        cost, current = heappop(pq)
        if cost > dist[current]:
            continue
        for ncost, neighbor in graph[current]:
            alt = cost + ncost
            if dist[neighbor] > alt:
                dist[neighbor] = alt
                heappush(pq, [alt, neighbor])
    return dist

def solution(n, s, a, b, fares):
    answer = 10 ** 9
    graph = [[] for _ in range(n)]
    for c, d, f in fares:
        graph[c - 1].append([f, d - 1])
        graph[d - 1].append([f, c - 1])
    # 모든 점에서 출발하여 A,B로 향하는 비용 계산
    for i in range(n):
        dist = dijkstra(graph, i, n)
        alt = dist[s - 1] + dist[a - 1] + dist[b - 1]
        answer = min(answer, alt)
    return answer

n = 6
s = 4
a = 5
b = 6
fares = [[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]
solution(n, s, a, b, fares)