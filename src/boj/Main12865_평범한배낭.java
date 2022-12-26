package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12865_평범한배낭 {

    static int n, k;
    static int[] W;
    static int[] V;
    static int[][] dp; // dp[i, j]: 고를 수 있는 물건의 범위가 [0,i]이고 버틸수있는 무게가 j이고 물건의 최대가치

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        //dp[i, j] = max(Vi + dp[i-1, j-Wi], dp[i-1, j])
        //모든 x에 대해서 dp[0,x] 초기화
        for (int x = 0; x <= k; x++) {
            if (W[0] <= x) {
                dp[0][x] = V[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (W[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], V[i] + dp[i - 1][j - W[i]]);
                }
            }
        }
        System.out.println(dp[n - 1][k]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        W = new int[n];
        V = new int[n];
        dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            W[i] = Integer.parseInt(str[0]);
            V[i] = Integer.parseInt(str[1]);
        }
    }
}
