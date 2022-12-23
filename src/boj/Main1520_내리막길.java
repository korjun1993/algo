package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1520_내리막길 {
    static int M, N;
    static int[][] map;
    static int[][] memo;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < M; i++) Arrays.fill(memo[i], -1);
        System.out.println(solve(0, 0));
    }

    // (x,y)에서 출발해서 (N-1,M-1)에 도착하는 모든 경우의 수를 memo에 적고 그 수를 반환하는 함수
    private static int solve(int y, int x) {
        if (y == M - 1 && x == N - 1) {
            return 1;
        }

        if (memo[y][x] != -1) {
            return memo[y][x];
        }

        // 탐색시작
        memo[y][x] = 0;

        for (int k = 0; k < 4; k++) {
            int ny = y + dir[k][0];
            int nx = x + dir[k][1];

            // 범위를 벗어나는 경우 탐색하지 않는다.
            if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;

            // 오르막길은 탐색하지 않는다.
            if (map[y][x] <= map[ny][nx]) continue;

            // 이동하려고봤더니 그곳에서 (N-1, M-1)까지 가는 경우의수가 이미 구해져있으면 사용한다. (2번째 base condition)
            memo[y][x] += solve(ny, nx);
        }
        return memo[y][x];
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[M][];
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
