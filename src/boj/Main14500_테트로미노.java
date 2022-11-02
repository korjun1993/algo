package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main14500_테트로미노 {
    static int n, m;
    static int ans;
    static int[][] arr;
    static int[][][] dir = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            {{0, 0}, {0, 1}, {1, 1}, {0, 2}}
    };

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int k = 0; k < 4; k++) {
            rotate();
            for (int x = 0; x < arr.length; x++) {
                for (int y = 0; y < arr[0].length; y++) {
                    solve(x, y);
                }
            }
        }
        System.out.println(ans);
    }

    private static void solve(int x, int y) {
        for (int i = 0; i < dir.length; i++) {
            boolean bound = true;
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + dir[i][j][0];
                int ny = y + dir[i][j][1];
                if (nx < 0 || nx >= arr.length || ny < 0 || ny >= arr[0].length) {
                    bound = false;
                    break;
                }
                sum += arr[nx][ny];
            }
            if (bound) {
                ans = Math.max(ans, sum);
            }
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
        } catch (Exception e) {
        }
    }

    private static void rotate() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] result = new int[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                result[i][j] = arr[h - j - 1][i];
            }
        }
        arr = result;
    }
}
