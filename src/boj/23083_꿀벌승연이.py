p = 10 ** 9 + 7
n, m = map(int, input().split())
dp = [[0] * (m + 1) for _ in range(n + 1)]
k = int(input())

safe = [[True] * (m + 1) for _ in range(n + 1)]

for _ in range(k):
    x, y = map(int, input().split())
    safe[x][y] = False

for i in range(1, n + 1):
    if not safe[i][1]: break
    dp[i][1] = 1

for j in range(2, m + 1):
    for i in range(1, n + 1):
        if not safe[i][j]:
            continue
        dp[i][j] += dp[i - 1][j]
        if j % 2 == 0:
            dp[i][j] += dp[i][j - 1]
            if i + 1 <= n:
                dp[i][j] += dp[i + 1][j - 1]
        else:
            dp[i][j] += dp[i - 1][j - 1] + dp[i][j - 1]
        dp[i][j] %= p
print(dp[n][m])
