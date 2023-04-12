package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1463_1로만들기 {
    static int dp[];
    static int n;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        //1. dp배열 초기화
        dp[1] = 0;
        dp[2] = 1;

        //2. dp 배열 채우기
        //X가 3으로 나누어 떨어지면, 3으로 나눈다.
        //X가 2로 나누어 떨어지면, 2로 나눈다.
        //1을 뺀다.
        for (int number = 3; number <= n; number++) {
            dp[number] = dp[number - 1];
            if (number % 2 == 0) {
                dp[number] = Math.min(dp[number], dp[number / 2]);
            }
            if (number % 3 == 0) {
                dp[number] = Math.min(dp[number], dp[number / 3]);
            }
            dp[number]++;
        }
        System.out.println(dp[n]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
    }
}
