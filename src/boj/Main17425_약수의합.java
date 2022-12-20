package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main17425_약수의합 {
    public static final int N = 1000000;
    static int T;
    static int[] test; // 테스트케이스
    static long[] sum; // 약수의 합

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N / i; j++) {
                sum[i * j] += i;
            }
        }

        for (int i = 1; i <= N; i++) {
            sum[i] += sum[i - 1];
        }

        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            sb.append(sum[test[t]]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        test = new int[T];
        sum = new long[N + 1];
        for (int t = 0; t < T; t++) {
            test[t] = Integer.parseInt(br.readLine());
        }
    }
}
