H, W, X, Y = map(int, input().split())
A = [[0] * W for _ in range(H)]
B = [list(map(int, input().split())) for _ in range(H + X)]
for i in range(H):
    for j in range(W):
        A[i][j] = B[i][j] if i < X or j < Y else B[i][j] - A[i - X][j - Y]
        print(A[i][j], end=' ')
    print()