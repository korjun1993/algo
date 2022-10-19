package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main7569_토마토 {
    static int N, M, H;
    static int answer;
    static int[][][] map;
    static List<T> start;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    static class T {
        int x, y, z, v;

        public T(int x, int y, int z, int v) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        bfs(start);
        boolean ripe = check();
        System.out.println(ripe ? answer : -1);
    }

    private static boolean check() {
        boolean result = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] >= 0) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    private static void bfs(List<T> start) {
        Queue<T> que = new LinkedList<>();
        que.addAll(start);
        for (int i = 0; i < start.size(); i++) {
            T t = start.get(i);
            map[t.x][t.y][t.z] = -1;
        }
        while (!que.isEmpty()) {
            T t = que.poll();
            for (int d = 0; d < 6; d++) {
                int nx = t.x + dir[d][0];
                int ny = t.y + dir[d][1];
                int nz = t.z + dir[d][2];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M) {
                    continue; // bound check
                }
                if (map[nx][ny][nz] == 0) {
                    que.add(new T(nx, ny, nz, t.v + 1));
                    map[nx][ny][nz] = -1;
                    answer = Math.max(answer, t.v + 1);
                }
            }
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            H = Integer.parseInt(str[2]);
            map = new int[H][N][M];
            start = new LinkedList<>();
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    for (int k = 0; k < M; k++) {
                        if (map[i][j][k] == 1) {
                            start.add(new T(i, j, k, 0));
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
