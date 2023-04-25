DP = [[1] * 10 for _ in range(1002)]
for i in range(2, 1002):
    for j in range(10):
        DP[i][j] = (sum(DP[i - 1]) % 10007 if j == 0 else DP[i][j - 1] - DP[i - 1][j - 1]) % 10007
print(DP[int(input()) + 1][0])
