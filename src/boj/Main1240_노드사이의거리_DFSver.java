package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1240_노드사이의거리_DFSver {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Edge {
        int y, c;

        Edge(int y, int c) {
            this.y = y;
            this.c = c;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] con;

    public static void main(String[] args) {
        input();
        while (m-- > 0) {
            pro();
        }
    }

    private static void pro() {
        try {
            String str[] = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            dfs(x, -1, y, 0);
            System.out.println(ans);
        } catch (Exception e) {
        }
    }

    static int ans;

    private static void dfs(int x, int prev, int goal, int dist) {
        if (x == goal) {
            ans = dist;
            return;
        }
        for (Edge e : con[x]) {
            if (e.y == prev) continue;
            dfs(e.y, x, goal, dist + e.c);
        }
    }

    private static void input() {
        try {
            String str[] = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            con = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) con[i] = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int c = Integer.parseInt(str[2]);
                con[x].add(new Edge(y, c));
                con[y].add(new Edge(x, c));
            }
        } catch (Exception e) {

        }
    }
}
