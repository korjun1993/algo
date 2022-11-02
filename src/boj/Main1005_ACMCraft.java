package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1005_ACMCraft {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t, n, k, w;
    static int[] cost;
    static int[] dist;
    static int[] indeg;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            input();
            pro();
        }
    }

    private static void pro() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            dist[x] += cost[x];
            for (int y : adj[x]) {
                indeg[y]--;
                dist[y] = Math.max(dist[y], dist[x]);
                if (indeg[y] == 0) que.offer(y);
            }
        }

        System.out.println(dist[w]);
    }

    private static void input() throws Exception {
        int x, y;
        String[] str;
        str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        cost = new int[n + 1];
        dist = new int[n + 1];
        indeg = new int[n + 1];
        adj = new List[n + 1];
        str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(str[i - 1]);
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < k; i++) {
            str = br.readLine().split(" ");
            x = Integer.parseInt(str[0]);
            y = Integer.parseInt(str[1]);
            adj[x].add(y);
            indeg[y]++;
        }
        w = Integer.parseInt(br.readLine());
    }
}
