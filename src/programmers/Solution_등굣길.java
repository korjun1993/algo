package programmers;

public class Solution_등굣길 {
    static int[][] map;
    static int[][] dp;

    static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            map[x][y] = 1;
        }

        // dp table 초기화
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            if (map[i][1] == 0) {
                dp[i][1] += dp[i - 1][1];
            }
        }

        for (int i = 1; i <= m; i++) {
            if (map[1][i] == 0) {
                dp[1][i] += dp[1][i - 1];
            }
        }

        // dp table 채우기
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (map[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] % 1000000007;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 1}}));
    }
}
