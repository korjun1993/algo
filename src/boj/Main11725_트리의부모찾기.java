package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        dfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int v) {
        for (int i : adj[v]) {
            if (parent[i] > 0) continue;
            parent[i] = v;
            dfs(i);
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            adj = new LinkedList[N + 1];
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new LinkedList();
            }
            for (int i = 0; i < N - 1; i++) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                adj[x].add(y);
                adj[y].add(x);
            }
        } catch (Exception e) {
        }
    }
}
