package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1339_단어수학 {

    static int answer;
    static int N; // N: 단어의 수
    static int M; // M: 숫자 배당이 필요한 알파벳의 수
    static char[][] words; // words: 단어
    static boolean[] visited; // visited: 알파벳에 숫자를 배당했는가?
    static int[] number; // number: 알파벳에 배당된 숫자

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        solve(0, 9);
        System.out.println(answer);
    }

    private static void solve(int depth, int value) {
        if (depth == M) {
            answer = Math.max(answer, sum());
            return;
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            if (visited[i]) continue;
            number[i] = value;
            visited[i] = true;
            solve(depth + 1, value - 1);
            number[i] = 0;
            visited[i] = false;
        }
    }

    // 단어 수학 문제를 푼다.
    private static int sum() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            int value = 0; // j 번째 단어의 알파벳을 숫자로 바꾼 결과
            for (int j = 0; j < words[i].length; j++) {
                value *= 10;
                value += number[words[i][j]];
            }
            result += value;
        }
        return result;
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[91];
        number = new int[91];
        Arrays.fill(visited, true);
        N = Integer.parseInt(br.readLine());
        words = new char[N][];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words[i] = input.toCharArray();
            for (int j = 0; j < words[i].length; j++) {
                if (visited[words[i][j]]) M++;
                visited[words[i][j]] = false; // 등장한 알파벳만 숫자를 배당받을 수 있게 처리
            }
        }
    }
}
