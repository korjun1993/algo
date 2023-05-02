def rotate(k):
    return [l[::-1] for l in zip(*k)]


def boundcheck(r, c, n):
    return 0 <= r < n and 0 <= c < n


def solution(key, lock):
    m = len(key)
    n = len(lock)
    for _ in range(4):  # 4번 90도 회전
        key = rotate(key)
        for r in range(n):  # (r, c) 만큼 평행이동
            for c in range(n):
                locked = [True, True, True, True]
                for x in range(n):  # (x,y) 좌표에 대해 홈이 맞는지 확인
                    for y in range(n):
                        d = [[-r, -c], [-r, c], [r, -c], [r, c]]
                        for i in range(4):
                            ny = y + d[i][0]
                            nx = x + d[i][1]
                            if not boundcheck(ny, nx, m):
                                if lock[y][x] == 0:
                                    locked[i] = False
                                continue
                            elif key[ny][nx] == lock[y][x]:
                                locked[i] = False
                if True in locked:
                    return True
    return False


key = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
lock = [[1, 1, 1], [1, 1, 1], [1, 0, 1]]
print(solution(key, lock))
