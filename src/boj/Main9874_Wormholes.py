answer = 0
N = int(input())
cordi = {}
for _ in range(N):
    x, y = map(int, input().split())
    if y in cordi:
        cordi[y].append(x)
    else:
        cordi[y] = [x]

for list in cordi.values():
    answer += len(list) - 1

print(answer)