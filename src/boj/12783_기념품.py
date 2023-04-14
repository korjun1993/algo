from collections import deque

n = int(input())
# 큐의 맨앞에는 제거될 사람이 들어가있다
q = deque()

for i in range(1, n + 1):
    q.append(i)

num = 1  # 이동칸수

# 실제로 이동하는 거리 (이동할칸수 % 남은인원)
while len(q) > 1:
    move = (num ** 3) % len(q)
    for _ in range(move - 1):
        q.append(q.popleft())
    q.popleft()
    print(q)
    num += 1

print(q[0])
