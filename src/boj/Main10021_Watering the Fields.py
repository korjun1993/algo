from itertools import combinations

# input
N, C = map(lambda x: int(x), input().split())
vertex = [tuple(map(lambda x: int(x), input().split())) for _ in range(N)]
edges = []

# union-find
parent = [i for i in range(N)]


def getParent(x):
    if parent[x] == x:
        return x
    parent[x] = getParent(parent[x])
    return parent[x]


def unionParent(x, y):
    a = getParent(x)
    b = getParent(y)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def findParent(x, y):
    return getParent(x) == getParent(y)


# problem solve
for pair in list(combinations([i for i in range(N)], 2)):
    length = (vertex[pair[0]][0] - vertex[pair[1]][0]) ** 2 + (vertex[pair[0]][1] - vertex[pair[1]][1]) ** 2
    if length >= C:
        edges.append((pair[0], pair[1], length)) # 메모리 초과 해결!

# kruskal
answer = 0
edges.sort(key=lambda x: x[2])
for edge in edges:
    if not findParent(edge[0], edge[1]):
        unionParent(edge[0], edge[1])
        answer += edge[2]
print(answer)