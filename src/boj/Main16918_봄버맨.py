R, C, N = map(int, input().split())
map = []
time = [[0] * C for _ in range(R)]
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
for i in range(R):
    map.append(list(input()))
    for j in range(C):
        if map[i][j] == 'O':
            # 폭탄의 남은 시간을 2초로 설정
            time[i][j] = 2


def timepass():
    # 모든 폭탄의 남은 시간을 1초씩 감소
    for r in range(R):
        for c in range(C):
            if time[r][c] > 0:
                time[r][c] -= 1

    for r in range(R):
        for c in range(C):
            if time[r][c] == 0 and map[r][c] == 'O':
                # 폭탄을 터트린다.
                map[r][c] = '.'

                # 4방향에 있는 폭탄을 터트린다.
                for i in range(4):
                    nr = r + dy[i]
                    nc = c + dx[i]
                    if 0 <= nr < R and 0 <= nc < C and time[nr][nc] > 0:
                        time[nr][nc] = 0
                        map[nr][nc] = '.'


# 1초 동안 봄버맨은 아무것도 하지 않는다.
N -= 1

# 3과 4를 반복한다.
while N > 0:
    # 3 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
    N -= 1
    timepass()
    for i in range(R):
        for j in range(C):
            if map[i][j] == '.':
                map[i][j] = 'O'
                time[i][j] = 3
    if N <= 0:
        break

    # 4 설치된 폭탄이 폭발한다.
    N -= 1
    timepass()

# 결과 출력
for i in range(R):
    print(''.join(map[i]))
