import heapq

N = int(input())  # 정점의 수
M = int(input())  # 간선의 수
E = list(list(map(int, input().split())) for _ in range(M))
P = [n for n in range(N + 1)]  # 부모 노드


# 부모노드의 번호를 반환하는 함수
def getParent(x):
    if P[x] == x:
        return x
    P[x] = getParent(P[x])
    return P[x]


# 부모노드 동일 여부를 묻는 함수
def find(x, y):
    return getParent(x) != getParent(y)


# 부모노드를 병합하는 함수
def union(x, y):
    nx = getParent(x)
    ny = getParent(y)
    if nx > ny:
        P[nx] = ny
    else:
        P[ny] = nx


pq = []
cnt = 0
ans = 0
for e in E:
    heapq.heappush(pq, (e[2], e[0], e[1]))

while cnt < N - 1:
    e = heapq.heappop(pq)
    if find(e[1], e[2]):
        union(e[1], e[2])
        cnt += 1
        ans += e[0]

print(ans)