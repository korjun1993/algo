package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2011_암호코드 {

    static String crypto;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        if (crypto.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        long dp[][] = new long[5001][2];
        int n = crypto.length();
        dp[0][0] = dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            if (crypto.charAt(i - 1) != '0') {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000;
            }

            int doubleValue = Integer.parseInt(crypto.substring(i - 2, i));
            if (10 <= doubleValue && doubleValue <= 26) {
                dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % 1000000;
            }
        }
        long ans = (dp[n][0] + dp[n][1]) % 1000000;
        System.out.println(ans);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        crypto = br.readLine();
    }
}
