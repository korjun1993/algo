package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1744_수묶기 {
    static int N;
    static Integer[] A;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int answer = 0;

        // 오름차순으로 정렬 후 수 묶기 진행
        Arrays.sort(A);
        answer = solve(A);

        // 정답 출력
        System.out.println(answer);
    }

    private static int solve(Integer[] a) {
        int sum = 0;
        int l, r;

        // 음수 * 음수 또는 음수 * 0
        for (l = 0; l < N - 1; l += 2) {
            if (a[l] < 1 && a[l + 1] < 1) {
                sum += a[l] * a[l + 1];
            } else break;
        }

        // 양수 * 양수
        for (r = N - 1; r > 0; r -= 2) {
            if (a[r] > 1 && a[r - 1] > 1) {
                sum += a[r] * a[r - 1];
            } else break;
        }

        while (l <= r) {
            sum += a[l++];
        }

        return sum;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            A = new Integer[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }
        } catch (Exception e) {

        }
    }
}
