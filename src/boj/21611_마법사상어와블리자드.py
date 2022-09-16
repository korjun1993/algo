from collections import deque
import itertools

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
cmd = [list(map(int, input().split())) for _ in range(m)]
answer = [0, 0, 0, 0]


def tolist(board):
    list = deque()
    y, x = n // 2, n // 2
    dy = [0, 1, 0, -1]
    dx = [-1, 0, 1, 0]
    for i in range(2 * n - 1):
        j = i % 4
        k = i // 2 + 1
        for _ in range(k):
            y = y + dy[j]
            x = x + dx[j]
            if y >= 0 and x >= 0 and y < n and x < n and board[y][x] > 0:
                list.append(board[y][x])
    return list


def toboard(list):
    board = [[0] * n for _ in range(n)]
    y, x = n // 2, n // 2
    dy = [0, 1, 0, -1]
    dx = [-1, 0, 1, 0]
    i = 0
    while list:
        j = i % 4
        k = i // 2 + 1
        for _ in range(k):
            y = y + dy[j]
            x = x + dx[j]
            if y >= 0 and x >= 0 and y < n and x < n and list:
                board[y][x] = list.popleft()
        i += 1
    return board


def count(list):
    cnt = [0] * len(list)
    cnt[0] = 1
    for i in range(1, len(list)):
        if list[i] == list[i - 1]:
            cnt[i] = cnt[i - 1] + 1
        else:
            cnt[i] = 1
    return cnt


def delete(board, d, s):
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    y, x = n // 2, n // 2
    for _ in range(s):
        y += dy[d]
        x += dx[d]
        if y >= 0 and x >= 0 and y < n and x < n:
            board[y][x] = 0
    return board


def deletezero(board):
    return toboard(tolist(board))


def deleteblock(board):
    list = tolist(board)
    isdelete = False
    if len(list) > 0:
        nlist = deque()
        cnt = count(list)
        idx = len(cnt) - 1
        while idx >= 0:
            if cnt[idx] >= 4:
                answer[list[idx]] += cnt[idx]
                idx -= cnt[idx]
                isdelete = True
            else:
                nlist.appendleft(list[idx])
                idx -= 1
        board = toboard(nlist)
    return board, isdelete


def addblock(board):
    global n
    list = tolist(board)
    nlist = deque()
    if len(list) > 0:
        cnt = count(list)
        idx = len(cnt) - 1
        while idx >= 0:
            nlist.appendleft(list[idx])
            nlist.appendleft(cnt[idx])
            idx -= cnt[idx]
        if len(nlist) >= n ** 2:
            nlist = deque(itertools.islice(nlist, 0, n ** 2 - 1))
        board = toboard(nlist)
    return board


for d, s in cmd:
    board = delete(board, d - 1, s)
    board = deletezero(board)
    while True:
        board, isdelete = deleteblock(board)
        if not isdelete:
            break
    board = addblock(board)

print(answer[1] * 1 + answer[2] * 2 + answer[3] * 3)