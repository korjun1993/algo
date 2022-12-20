package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main15661_링크와스타트 {

    static int answer = 2000;
    static int N; // 사람의 수
    static int[][] S; // 능력치
    static int[] team; // 부여된 팀 (0:스타트팀, 1:링크팀)

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        solve(0);
        System.out.println(answer);
    }

    private static void solve(int person) {
        if (person == N) {
            answer = Math.min(answer, calc(team));
            return;
        }
        for (int i = 0; i <= 1; i++) {
            team[person] = i;
            solve(person + 1);
        }
    }

    private static int calc(int[] team) {
        int[] score = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] == team[j]) {
                    score[team[i]] += S[i][j];
                }
            }
        }
        return Math.abs(score[0] - score[1]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][];
        team = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
