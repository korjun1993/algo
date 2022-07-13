n = int(input())
t = []
x = []
s = []
map = [input().split() for _ in range(n)]
answer = [False]  # mutable 처리


def check():
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]
    for teacher in t:
        for i in range(4):
            r, c = teacher
            while True:
                r += dr[i]
                c += dc[i]
                if (r < 0 or r >= n or c < 0 or c >= n) or map[r][c] == 'O':
                    break
                if map[r][c] == 'S':
                    return False
    return True


# cnt개를 이미 고른 상태에서
# 이전에 고른 좌표의 인덱스가 idx이고,
# 총 3개의 좌표를 고를 때 까지
# 해당 좌표에 장애물을 놓는 함수
def dfs(cnt, idx):
    if cnt == 3:
        if check():
            answer[0] = True
        return

    for cand in range(idx + 1, len(x)):
        r, c = x[cand]
        map[r][c] = 'O'
        dfs(cnt + 1, cand)
        map[r][c] = 'X'


for i in range(n):
    for j in range(n):
        if map[i][j] == 'T':
            t.append((i, j))
        elif map[i][j] == 'X':
            x.append((i, j))

dfs(0, -1)

print("YES" if answer[0] else "NO")
