import heapq

# input
N, C = map(int, input().split())
vertex = []
for i in range(N):
    x, y = map(int, input().split())
    vertex.append((i, x, y))
chk = [False] * N
pq = []
cnt = 0
answer = 0
# problem solve
# prim-algorithm
chk[0] = True
for i in range(1, len(vertex)):
    cost = (vertex[0][1] - vertex[i][1]) ** 2 + (vertex[0][2] - vertex[i][2]) ** 2
    if cost >= C:
        heapq.heappush(pq, (cost, vertex[i][0]))

while cnt < N - 1:
    if not pq:
        break # C보다 비용이 큰 간선만 추가되므로, N-1개를 선택하기 전에 pq가 empty일 가능성 있음
    cand = heapq.heappop(pq)
    if chk[cand[1]]:
        continue
    chk[cand[1]] = True
    cnt += 1
    answer += cand[0]

    for i in range(0, len(vertex)):
        if i != cand[1] and not chk[i]:
            cost = (vertex[cand[1]][1] - vertex[i][1]) ** 2 + (vertex[cand[1]][2] - vertex[i][2]) ** 2
            if cost >= C:
                heapq.heappush(pq, (cost, i))

if cnt < N - 1:
    answer = -1

print(answer)
