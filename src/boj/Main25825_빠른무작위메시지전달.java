package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main25825_빠른무작위메시지전달 {
    static int[][] cost = new int[13][13];
    static boolean[] vis = new boolean[7];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        solve(1, 0, 0);
        System.out.println(answer);
    }

    private static void solve(int depth, int pre, int time) {
        if (depth == 13) {
            answer = Math.min(answer, time);
            return;
        }

        // 같은 집단에서 학생을 고르기
        int cand = 0;
        if (depth % 2 == 0) {
            cand = pre % 2 == 0 ? pre - 1 : pre + 1;
            solve(depth + 1, cand, time + cost[pre][cand]);
        }

        // 새로운 집단에서 학생을 고르기
        else {
            for (int i = 1; i <= 6; i++) { // group number = 1~6
                if (vis[i]) continue;
                vis[i] = true;
                cand = i * 2 - 1;
                solve(depth + 1, cand, time + cost[pre][cand]);
                cand = i * 2;
                solve(depth + 1, cand, time + cost[pre][cand]);
                vis[i] = false;
            }
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 1; i <= 12; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 1; j <= 12; j++) {
                    cost[i][j] = Integer.parseInt(str[j - 1]);
                }
            }
        } catch (Exception e) {
        }
    }
}
