# r : 시작 행
# c : 시작 열
# n : 배열의 길이
# num : 배열에 쓰일 숫자
# arr : 정답을 담은 배열
def func(r, c, n, num, arr):
    # 행 ++
    while r + 1 < n and arr[r + 1][c] == 0:
        r += 1
        num += 1
        arr[r][c] = num

    # 열 ++
    while c + 1 < n and arr[r][c + 1] == 0:
        c += 1
        num += 1
        arr[r][c] = num

    # 행, 열 --
    while c - 1 >= 0 and r - 1 >= 0 and arr[r - 1][c - 1] == 0:
        r -= 1
        c -= 1
        num += 1
        arr[r][c] = num

    if r + 1 < n and arr[r + 1][c] == 0:
        func(r, c, n, num, arr)


def solution(n):
    answer = []
    temp = [[0] * n for _ in range(n)]
    func(-1, 0, n, 0, temp)
    for t in temp:
        answer.extend([n for n in t if n > 0])
    return answer