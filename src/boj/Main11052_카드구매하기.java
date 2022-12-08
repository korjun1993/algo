package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main11052_카드구매하기 {
    static int n;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        dp[1] = p[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], p[j] + dp[i - j]);
            }
        }
        System.out.println(dp[n]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n + 1];
        dp = new int[n + 1];
        String str[] = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(str[i - 1]);
        }
    }
}
