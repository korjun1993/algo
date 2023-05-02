answer = 0


def solution(board):
    global answer
    map = [['.' for _ in range(3)] for _ in range(3)]
    solve(map, board, 0)
    return answer


def solve(visit, board, location):
    if location >= 9:
        if equal(visit, board):
            global answer
            answer = 1
        return

    row = location // 3
    col = location % 3

    for k in ['.', 'O', 'X']:
        visit[row][col] = k
        solve(visit, board, location + 1)


def equal(visit, board):
    result = True
    for i in range(3):
        if ''.join(visit[i]) != board[i]:
            result = False
    return result


print(solution(["O.X", ".O.", "..X"]))
