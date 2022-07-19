import heapq

N = int(input())
A = []
Q = []
for _ in range(N):
    A.append(list(map(int, input().split())))
A.sort(key=lambda x: x[0])
for s, e in A:
    if Q and s >= Q[0]:  # 사용중인 회의실이 있을 때, 그 회의실을 그대로 사용할지 결정
        heapq.heappop(Q)
    heapq.heappush(Q, e)
print(len(Q))
