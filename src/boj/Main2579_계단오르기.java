package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // process
        int answer = solution(n, A);

        // 정답 출력
        System.out.println(answer);
    }

    private static int solution(int n, int[] A) {
        if (n <= 1) return A[1];

        // 초기값 설정
        int dy[] = new int[300 + 1];
        dy[1] = A[1];
        dy[2] = A[1] + A[2];

        // 동적프로그래밍
        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 3] + A[i] + A[i - 1], dy[i - 2] + A[i]);
        }

        return dy[n];
    }
}
