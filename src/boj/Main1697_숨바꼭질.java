package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1697_숨바꼭질 {
    static int N, K;
    static int[] dist;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        bfs(N);
        System.out.println(dist[K]);
    }

    private static void bfs(int n) {
        // 시작점 체크
        Queue<Integer> que = new LinkedList();
        dist[n] = 0;
        que.add(n);

        // bfs 과정 시작
        while (!que.isEmpty()) {
            int x = que.poll();
            for (int k = 0; k < 3; k++) {
                int nx = x + next(x, k);
                if (nx < 0 || nx > 100000) {
                    continue;
                }
                if (dist[nx] >= 0) {
                    continue;
                }
                dist[nx] = dist[x] + 1;
                que.add(nx);
            }
        }
    }

    private static int next(int x, int k) {
        if (k == 0) {
            return 1;
        } else if(k == 1) {
            return -1;
        } else {
            return x;
        }
    }


    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str[] = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);
            dist = new int[100001];
            Arrays.fill(dist, -1);
        } catch (Exception e) {
        }
    }
}
