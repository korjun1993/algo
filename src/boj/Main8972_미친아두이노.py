dy = (0, 1, 1, 1, 0, 0, 0, -1, -1, -1)
dx = (0, -1, 0, 1, -1, 0, 1, -1, 0, 1)
R, C = map(int, input().split())
map = [[] for _ in range(R)]
jongsu = []
aduino = []
remove = []
cnt = [0]

for i in range(R):
    map[i] = list(input())
    for j in range(C):
        if map[i][j] == 'I':
            jongsu = [i, j]
        elif map[i][j] == 'R':
            aduino.append([i, j])

cmds = input()


def move(k, cmd):
    y, x = k
    if k == jongsu:
        k[0] += dy[cmd]
        k[1] += dx[cmd]
        if map[k[0]][k[1]] == 'R':
            return True  # 움직인 곳에 미친 아두이노가 존재하여 게임 패배
        else:
            # 상태업데이트
            map[y][x], map[k[0]][k[1]] = map[k[0]][k[1]], map[y][x]
            cnt[0] += 1

    else:  # 미친 아두이노
        min_dis = 200
        min_idx = 0
        for i in range(8):
            ny = k[0] + dy[i]
            nx = k[1] + dx[i]
            d = abs(jongsu[0] - ny) + abs(jongsu[1] - nx)
            if d < min_dis:
                min_dis = d
                min_idx = i

        k[0] += dy[min_idx]
        k[1] += dx[min_idx]
        if map[k[0]][k[1]] == 'R':
            if [k[0], k[1]] not in remove:
                remove.append([k[0], k[1]])
            return True  # 2개 이상의 아두이노가 같은 칸에 있어 폭발
        else:
            # 상태업데이트
            map[y][x], map[k[0]][k[1]] = map[k[0]][k[1]], map[y][x]
    return False


for cmd in cmds:
    if move(jongsu, int(cmd)):  # 종수가 움직인다
        print(f"kraj {cnt}")
        break

    for a in aduino:  # 미친 아두이노를 움직인다
        if move(a, cmd):
            print(f"kraj {cnt[0]}")
            break

    if len(remove) > 0:
        aduino = [a for a in aduino if a not in remove]
        remove.clear()

# 정답 출력
for i in range(R):
    for j in range(C):
        p노rint(map[i][j], end=' ')
    print()
