package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main1516_게임개발 {
    static int n;
    static int[] indegree;
    static int[] cost;
    static int[] ans;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
                ans[i] = cost[i];
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                indegree[y]--;
                if (indegree[y] == 0) que.offer(y);
                ans[y] = Math.max(ans[y], ans[x] + cost[y]);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            indegree = new int[n + 1];
            cost = new int[n + 1];
            ans = new int[n + 1];
            adj = new List[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                String[] str = br.readLine().split(" ");
                cost[i] = Integer.parseInt(str[0]);
                for (int j = 1; ; j++) {
                    int x = Integer.parseInt(str[j]);
                    if (x == -1) break;
                    adj[x].add(i);
                    indegree[i]++;
                }
            }
        } catch (Exception e) {
        }
    }
}