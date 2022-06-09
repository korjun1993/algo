package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095 {
    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int answer = proc(n);
            System.out.println(answer);
        }
    }

    private static int proc(int n) {
        int dy[] = new int[15];

        // 초기값 구하기
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        // 점화식을 토대로 dy 배열 채우기
        for (int i = 4; i <= 11; i++) {
            dy[i] = dy[i - 3] + dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }
}
