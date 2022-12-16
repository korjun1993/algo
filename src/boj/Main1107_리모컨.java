package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1107_리모컨 {
    static boolean[] hasError;
    static int n, m, k;
    static int answer;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        answer = Math.abs(100 - n); // +,- 버튼으로 채널이동할 때, 버튼입력수
        solve(0, ""); // +,- 및 숫자버튼으로 채널 이동할 때, 버튼입력수
        System.out.println(answer);
    }

    private static void solve(int depth, String selected) {
        if (!"".equals(selected)) {
            int count = Math.abs(Integer.parseInt(selected) - n) + depth;
            answer = Math.min(answer, count);
        }

        if (depth == m) {
            return;
        }

        for (int number = 0; number < 10; number++) {
            if (hasError[number]) continue;
            solve(depth + 1, selected + number);
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        m = String.valueOf(n).length() + 1;
        hasError = new boolean[10];
        if (k == 0) return;
        String[] inputValue = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(inputValue[i]);
            hasError[number] = true;
        }
    }
}
