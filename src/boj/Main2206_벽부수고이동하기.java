package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2206_벽부수고이동하기 {
    static int N, M;
    static String[] map;
    static boolean[][][] visited;
    static int[][][] dist;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new String[N];
        visited = new boolean[N][M][2];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }
    }

    private static void pro() {
        Queue<Integer> queue = new LinkedList<>();

        // (0,0)에서 출발
        Arrays.fill(dist[0][0], 1);
        insert(queue, 0, 0, 0);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int count = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][1];
                int ny = y + dir[k][0];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (visited[ny][nx][count]) continue;
                if (map[ny].charAt(nx) == '1' && count == 0) {
                    dist[ny][nx][1] = dist[y][x][0] + 1;
                    insert(queue, nx, ny, 1);
                } else if (map[ny].charAt(nx) == '0') {
                    dist[ny][nx][count] = dist[y][x][count] + 1;
                    insert(queue, nx, ny, count);
                }
            }
        }

        // 0보다 큰 값중 가장 작은값
        List<Integer> cand = new LinkedList<>();
        for (int i = 0; i < 2; i++) if (dist[N - 1][M - 1][i] > 0) cand.add(dist[N - 1][M - 1][i]);
        Collections.sort(cand);
        System.out.println(cand.isEmpty() ? -1 : cand.get(0));
    }

    // x: 이동하고자하는 곳의 x좌표
    // y: 이동하고자하는 곳의 y좌표
    // count: 벽을 깨부순 횟수
    private static void insert(Queue<Integer> queue, int x, int y, int count) {
        visited[y][x][count] = true;
        queue.add(x);
        queue.add(y);
        queue.add(count);
    }
}
