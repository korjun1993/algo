package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main14391_종이조각 {
    static int n, m, answer;
    static int[][] nums;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        solve("");
        System.out.println(answer);
    }


    private static void solve(String state) {
        if (state.length() > n * m) {
            // 가로 계산
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int value = 0;
                for (int j = 0; j < m; j++) {
                    if (state.charAt(m * i + j) == '1') {
                        sum += value;
                        value = 0;
                    } else {
                        value *= 10;
                        value += nums[i][j];
                    }
                }
                sum += value;
            }
            // 세로 계산
            for (int i = 0; i < m; i++) {
                int value = 0;
                for (int j = 0; j < n; j++) {
                    if (state.charAt(m * j + i) == '0') {
                        sum += value;
                        value = 0;
                    } else {
                        value *= 10;
                        value += nums[j][i];
                    }
                }
                sum += value;
            }
            answer = Math.max(answer, sum);
            return;
        }
        solve(state + "0");
        solve(state + "1");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        nums = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                nums[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
    }
}
