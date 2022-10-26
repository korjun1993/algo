package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main1240_노드사이의거리 {
    static int N, M;
    static int[] start;
    static List<Pair>[] adj;
    static int[] dist;

    static class Pair {
        int v, cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < 2 * M; i += 2) {
            Arrays.fill(dist, -1);
            int ans = bfs(start[i], start[i + 1]);
            System.out.println(ans);
        }
    }

    private static int bfs(int start, int dest) {
        Queue<Integer> que = new LinkedList();
        dist[start] = 0;
        que.add(start);

        while (!que.isEmpty()) {
            int x = que.poll();
            for (Pair y : adj[x]) {
                if (dist[y.v] >= 0) continue;
                dist[y.v] = dist[x] + y.cost;
                que.add(y.v);
            }
        }

        return dist[dest];
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);
            start = new int[M * 2];
            adj = new List[N + 1];
            dist = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                adj[i] = new LinkedList<>();
            }

            // tree 정보 입력받기
            for (int i = 0; i < N - 1; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int cost = Integer.parseInt(str[2]);
                adj[x].add(new Pair(y, cost));
                adj[y].add(new Pair(x, cost));
            }

            // 두 점의 번호 얻기
            for (int i = 0; i < 2 * M; i += 2) {
                str = br.readLine().split(" ");
                start[i] = Integer.parseInt(str[0]);
                start[i + 1] = Integer.parseInt(str[1]);
            }
        } catch (Exception e) {
        }
    }
}
