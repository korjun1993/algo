package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main14502_연구소 {
    static int[][] map;
    static int N, M;
    static int answer;
    static int[] selected;
    static boolean[] check;
    static List<Coord> V;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Coord {
        int x, y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        solve(0);
        System.out.println(answer);
    }

    private static void solve(int k) {
        if (k == 3) {
            answer = Math.max(answer, bfs(V, selected));
            return;
        }

        int start = 0;
        if (k > 0) {
            start = selected[k - 1] + 1;
        }

        for (int i = start; i < N * M; i++) {
            if (check[i] || map[i / M][i % M] != 0) continue;
            selected[k] = i;
            check[i] = true;
            solve(k + 1);
            selected[k] = 0;
            check[i] = false;
        }
    }

    private static int bfs(List<Coord> v, int[] selected) {
        int result = 0;
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(map[i], M);
        }
        for (int wall : selected) {
            int x = wall / M;
            int y = wall % M;
            temp[x][y] = 1;
        }
        Queue<Coord> que = new LinkedList();
        que.addAll(V);
        while (!que.isEmpty()) {
            Coord c = que.poll();
            for (int d = 0; d < 4; d++) {
                int nx = c.x + dir[d][0];
                int ny = c.y + dir[d][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    que.add(new Coord(nx, ny));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            result += Arrays.stream(temp[i]).filter(x -> x == 0).count();
        }
        return result;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str[] = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            map = new int[N][];
            V = new LinkedList<>();
            check = new boolean[100];
            selected = new int[3];
            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        V.add(new Coord(i, j));
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
