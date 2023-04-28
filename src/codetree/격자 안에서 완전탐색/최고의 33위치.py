N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
answer = 0

for i in range(N):
    for j in range(N):
        out = False
        total = 0
        for k in range(3):
            for l in range(3):
                if N <= i + k or N <= j + l:
                    out = True
                    continue
                total += board[i + k][j + l]
        if not out:
            answer = max(answer, total)

print(answer)