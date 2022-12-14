package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_20413_MVP다이아몬드 {
    static int n; // 게임 플레이 한 개월수
    static int[] limit;
    static int[][] dp;
    static char[] mvp;
    static int rank[] = {'B', 'S', 'G', 'P'};

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][100];
        limit = new int[100];
        String str[] = br.readLine().split(" ");
        for (int i = 0; i < rank.length; i++) {
            limit[rank[i]] = Integer.parseInt(str[i]) - 1;
        }
        mvp = br.readLine().toCharArray();
    }

    private static void pro() {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int limitPrice = limit[mvp[i - 1]];
            if (mvp[i - 1] == 'D') { // 이번달 등급이 다이아몬드라면
                limitPrice = dp[i - 1][mvp[i - 1]] + limit['P'] + 1; // 이번달 과금액 <= 전달 + 다이아몬드 등급 기준액
            }
            for (int j = 0; j < 4; j++) {
                dp[i][rank[j]] = Math.min(limitPrice - dp[i - 1][mvp[i - 1]], limit[rank[j]]);
            }
            dp[i]['D'] = Math.min(limitPrice - dp[i - 1][mvp[i - 1]], limit['P'] + 1);
            ans += dp[i - 1][mvp[i - 1]];
        }
        ans += dp[n][mvp[n - 1]];
        System.out.println(ans);
    }
}