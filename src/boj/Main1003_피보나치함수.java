package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1003_피보나치함수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int dp[][];

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        pro();

        for (int t = 0; t < T; t++) {
            input();
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    // dp[x][0] = fibonacci(x) 호출시 0이 출력되는 횟수
    // dp[x][1] = fibonacci(x) 호출시 1이 출력되는 횟수
    private static void pro() {
        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }
    }

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }
}
