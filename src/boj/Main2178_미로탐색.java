package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2178_미로탐색 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int answer = bfs(1, 1);
        System.out.println(answer);
    }

    private static int bfs(int r, int c) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> que = new LinkedList<>();
        int vis[][] = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(vis[i], -1);
        }
        vis[r][c] = 1;
        que.add(r);
        que.add(c);
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx <= 0 || ny <= 0 || nx > N || ny > M || map[nx][ny] == 0 || vis[nx][ny] >= 0) {
                    continue;
                }
                vis[nx][ny] = vis[x][y] + 1;
                que.add(nx);
                que.add(ny);
            }
        }
        return vis[N][M];
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            map = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j + 1] = Character.getNumericValue(input.charAt(j));
                }
            }
        } catch (Exception e) {
        }
    }
}
