# import heapq
#
# # input
# N, C = map(int, input().split())
# vertex = []
# for i in range(N):
#     x, y = map(int, input().split())
#     vertex.append((i, x, y))
# chk = [False] * N
# pq = []
# cnt = 0
# answer = 0
# # problem solve
# # prim-algorithm
# chk[0] = True
# for i in range(1, len(vertex)):
#     cost = (vertex[0][1] - vertex[i][1]) ** 2 + (vertex[0][2] - vertex[i][2]) ** 2
#     if cost >= C:
#         heapq.heappush(pq, (cost, vertex[i][0]))
#
# while cnt < N - 1:
#     if not pq:
#         break # C보다 비용이 큰 간선만 추가되므로, N-1개를 선택하기 전에 pq가 empty일 가능성 있음
#     cand = heapq.heappop(pq)
#     if chk[cand[1]]:
#         continue
#     chk[cand[1]] = True
#     cnt += 1
#     answer += cand[0]
#
#     for i in range(0, len(vertex)):
#         if i != cand[1] and not chk[i]:
#             cost = (vertex[cand[1]][1] - vertex[i][1]) ** 2 + (vertex[cand[1]][2] - vertex[i][2]) ** 2
#             if cost >= C:
#                 heapq.heappush(pq, (cost, i))
#
# if cnt < N - 1:
#     answer = -1
#
# print(answer)

import heapq

# input
N, C = map(lambda x: int(x), input().split())
vertex = [tuple(map(lambda x: int(x), input().split())) for _ in range(N)]
edges = []
pq = []

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
# make edges
# for pair in list(combinations([i for i in range(N)], 2)):
#     length = (vertex[pair[0]][0] - vertex[pair[1]][0]) ** 2 + (vertex[pair[0]][1] - vertex[pair[1]][1]) ** 2
#     if length >= C:
#         heapq.heappush(pq, (pair[0], pair[1], length))
# ===> combinations : 크기가 최대 원소의 갯수가 200만개인 list 생성되므로 메모리 초과
# ===> 아래와 같이 for문으로 대체

for i in range(0, len(vertex)):
    for j in range(i + 1, len(vertex)):
        length = (vertex[i][0] - vertex[j][0]) ** 2 + (vertex[i][1] - vertex[j][1]) ** 2
        if length >= C:
            heapq.heappush(pq, (length, i, j))

# kruskal
answer = 0
cnt = 0
while cnt < N - 1 and pq:
    edge = heapq.heappop(pq)
    if not findParent(edge[1], edge[2]):
        unionParent(edge[1], edge[2])
        answer += edge[0]
        cnt += 1

if cnt < N - 1:
    answer = -1
print(answer)