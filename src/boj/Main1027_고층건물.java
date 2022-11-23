package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1027_고층건물 {
    static int n;
    static int ans;
    static double[] height;
    static double[][] incline;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                incline[i][j] = (height[i] - height[j]) / Math.abs(i - j);
            }
        }

        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i + 1;
            double limit = 1000000000;
            int count = 0;

            // 왼쪽 탐색
            while (l >= 0) {
                if (limit > incline[i][l]) {
                    count++;
                    limit = incline[i][l];
                }
                l--;
            }

            // 오른쪽 탐색
            limit = 1000000000;
            while (r < n) {
                if (limit > incline[i][r]) {
                    count++;
                    limit = incline[i][r];
                }
                r++;
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            height = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            incline = new double[n][n];
        } catch (Exception ignored) {

        }
    }
}
