A, B = map(int, input().split())
N, M = map(int, input().split())
robot = [list(map(lambda x: int(x) if x.isdigit() else x, input().split())) for _ in range(N)]
cmd = [list(map(lambda x: int(x) if x.isdigit() else x, input().split())) for _ in range(M)]
map = [[0] * (A + 1) for _ in range(B + 1)]
answer = ["OK"]  # 정상여부

# 로봇 인덱스 1칸씩 미루기
robot.insert(0, [])

# 문자로 써져있는 방향을 숫자로 변경
for i in range(1, len(robot)):
    if robot[i][2] == 'N':
        robot[i][2] = 0
    elif robot[i][2] == 'E':
        robot[i][2] = 1
    elif robot[i][2] == 'S':
        robot[i][2] = 2
    elif robot[i][2] == 'W':
        robot[i][2] = 3

    # map에 로봇의 위치 표시
    x, y, d = robot[i]
    map[y][x] = i


# 명령을 정상 수행했을 시, True를 반환하는 함수
def process(rbt_num, rbt_cmd, rbt_cnt):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    # 로봇의 현재 상태
    x, y, d = robot[rbt_num]

    # 전진 명령
    if rbt_cmd == 'F':
        for _ in range(rbt_cnt):
            x += dx[d]
            y += dy[d]
            if y <= 0 or y > B or x <= 0 or x > A:
                answer[0] = f'Robot {rbt_num} crashes into the wall'
                return False
            if map[y][x] != 0:
                answer[0] = f'Robot {rbt_num} crashes into robot {map[y][x]}'
                return False

        # 상태 업데이트
        before = robot[rbt_num]
        robot[rbt_num] = [x, y, d]
        map[y][x], map[before[1]][before[0]] = map[before[1]][before[0]], map[y][x]

    # 90도 회전 명령
    elif rbt_cmd == 'R':
        robot[rbt_num][2] = (robot[rbt_num][2] + rbt_cnt) % 4

    # -90도 회전 명령
    elif rbt_cmd == 'L':
        robot[rbt_num][2] = (robot[rbt_num][2] - rbt_cnt) % 4

    return True


for c in cmd:
    rbt_num = c[0]  # 로봇 번호
    rbt_cmd = c[1]  # 명령의 종류
    rbt_cnt = c[2]  # 명령의 반복횟수

    # 명령 수행
    if not process(rbt_num, rbt_cmd, rbt_cnt):
        break  # process 명령 실패시 중단 (로봇의 벽면이탈 or 로봇끼리 충돌)

print(answer[0])
