package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main1932_정수삼각형 {
    static int n;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = arr[i][j];
                int v1 = dp[i - 1][j];
                int v2 = j > 0 ? dp[i - 1][j - 1] : 0;
                dp[i][j] += Math.max(v1, v2);
            }
        }
        System.out.println(IntStream.of(dp[n - 1]).max().getAsInt());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
    }
}
