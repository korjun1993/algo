from itertools import combinations

answer = 0
n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

e = [[0,0], [1,0], [0,1], [1,1]]
blocks = [[[0,0],[0,1],[0,2]], [[0,0], [1,0], [2,0]]]


for d in list(combinations(e, 3)) + blocks:
    for i in range(n):
        for j in range(m):
            out = False
            total = 0
            for k in range(3):
                x = i + d[k][0]
                y = j + d[k][1]
                if n <= x or m <= y:
                    out = True
                    break
                total += board[x][y]
            if not out:
                answer = max(answer, total)

print(answer)