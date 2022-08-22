answer = [0, 0]


def func(arr, r, c, n):
    dr = [0, 0, n // 2, n // 2]
    dc = [0, n // 2, 0, n // 2]
    all_same = True
    for i in range(n):
        for j in range(n):
            if arr[r][c] != arr[r + i][c + j]:
                all_same = False
                for i in range(4):
                    func(arr, r + dr[i], c + dc[i], n // 2)
                return
    if all_same:
        answer[arr[r][c]] -= n ** 2
        answer[arr[r][c]] += 1


def solution(arr):
    for a in arr:
        answer[0] += a.count(0)
        answer[1] += a.count(1)

    func(arr, 0, 0, len(arr[0]))
    return answer


arr = [[1, 1, 0, 0], [1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 1, 1]]
