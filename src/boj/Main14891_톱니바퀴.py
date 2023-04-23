gear = [list(input()) for _ in range(4)]
K = int(input())
cmd = [list(map(int, input().split())) for _ in range(K)]


def move(n, d):
    tmp = gear[n][0]
    d *= -1
    for i in range(7):
        gear[n][i * d] = gear[n][d * (i + 1)]
    gear[n][7 * d] = tmp


# n번 gear를 회전시킬 때,
# [0 ~ n-1], [n + 1 ~ 3] gear가 움직일지 확인하는 함수
def check(n, pre):
    global dir, visited
    visited[n] = True

    if n < 0 or n >= 4 or visited[n]:
        return

    # 다른 gear에 의해 회전하는 경우, 어떤 gear로부터 영향을 받는지 확인
    d = 1 if pre < n else -1
    if n != pre and gear[pre][2 * d] != gear[n][-2 * d]:
        dir[n] = -dir[pre]

    check(n - 1, n)
    check(n + 1, n)


for c in cmd:
    n, d = c[0] - 1, c[1]
    dir = [0] * 4
    dir[n] = d
    visited = [False] * 4
    check(n, n)
    for i in range(4):
        if dir[i] != 0:
            move(i, dir[i])

print(sum(2 ** i for i in range(4) if gear[i][0] == '1'))

# boj에서 가져온 short coding
# from collections import deque
# GR = [deque(list(map(int, input()))) for _ in range(4)]
#
# for _ in range(int(input())):
#     mid, d = map(int, input().split())
#     mid -= 1
#     GR[mid].rotate(d)
#
#     l, r = mid-1, mid+1
#
#     M, D = mid, d
#     while 0 <= l and GR[M][6+D] != GR[l][2]:
#         l, M, D = l-1, l, D*(-1)
#         GR[M].rotate(D)
#
#     M, D = mid, d
#     while r < 4 and GR[M][2+D] != GR[r][6]:
#         r, M, D = r+1, r, D * (-1)
#         GR[M].rotate(D)
#
# print(sum(1<<i for i in range(4) if GR[i][0] == 1))
