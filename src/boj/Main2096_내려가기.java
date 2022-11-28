package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2096_내려가기 {
    static int n;
    static int[][] arr;
    static int[][] max;
    static int[][] min;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        // 초기화
        for (int i = 0; i < 3; i++) {
            max[0][i] = min[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            // 최댓점수 구하기
            max[i][0] = arr[i][0] + Math.max(max[i - 1][0], max[i - 1][1]);
            max[i][1] = arr[i][1] + Arrays.stream(max[i - 1]).max().getAsInt();
            max[i][2] = arr[i][2] + Math.max(max[i - 1][1], max[i - 1][2]);

            // 최소점수 구하기
            min[i][0] = arr[i][0] + Math.min(min[i - 1][0], min[i - 1][1]);
            min[i][1] = arr[i][1] + Arrays.stream(min[i - 1]).min().getAsInt();
            min[i][2] = arr[i][2] + Math.min(min[i - 1][1], min[i - 1][2]);
        }

        System.out.print(Arrays.stream(max[n - 1]).max().getAsInt() + " ");
        System.out.print(Arrays.stream(min[n - 1]).min().getAsInt());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][];
        max = new int[n][3];
        min = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
