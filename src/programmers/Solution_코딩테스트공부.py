def solution(alp, cop, problems):
    n = max(list(p[0] for p in problems)) + 1 # 알고력
    m = max(list(p[1] for p in problems)) + 1 # 코딩력
    dp = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):

            for k in problems:
                ni, nj = i - k[2], j - k[3]
                if ni < 0 or nj < 0: continue
                if ni >= k[0] and nj >= k[1]:
                    cost = min(cost, k[4] + dp[ni][nj])
            dp[i][j] = cost
    for i in range(n):
        for j in range(m):
            print('%2d' % dp[i][j], end= ' ')
        print()
    return dp[n-1][m-1] - dp[alp][cop]

alp = 0
cop = 0
problems = [[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]
ans = solution(alp, cop, problems)
print(ans)