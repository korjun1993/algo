n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
answer = 0

for i in range(n):
    max_length = 1
    length = 1
    for j in range(1, n):
        if board[i][j] == board[i][j - 1]:
            length += 1
            max_length = max(max_length, length)
        else:
            length = 1
    if m <= max_length:
        answer += 1

for i in range(n):
    max_length = 1
    length = 1
    for j in range(1, n):
        if board[j][i] == board[j - 1][i]:
            length += 1
            max_length = max(max_length, length)
        else:
            length = 1
    if m <= max_length:
        answer += 1

print(answer)