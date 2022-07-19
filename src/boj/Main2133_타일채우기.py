N = int(input())
DP = [1, 0, 3] + [0] * 30
for i in range(4, 31, 2):
    DP[i] = 4 * DP[i - 2] - DP[i - 4]
print(DP[N])