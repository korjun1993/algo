package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main2252_줄세우기 {
    static int n, m;
    static int[] indeg;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(' ');

            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
            }
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            adj = new List[n + 1];
            indeg = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new LinkedList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                adj[x].add(y);
                indeg[y]++;
            }
        } catch (Exception e) {

        }
    }
}

