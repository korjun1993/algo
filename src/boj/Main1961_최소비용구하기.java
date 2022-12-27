package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1961_최소비용구하기 {
    static class Cost { // Cost: 도시 A에서 출발해서 도시x에 도착할 때 드는 비용
        int x, value;

        public Cost(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }

    static int N; // N: 도시의 개수
    static int M; // M: 버스의 개수
    static int A; // A: 출발 도시
    static int B; // B: 도착 도시
    static int[] cost; // cost[i]: 출발점에서 i까지 가는데 드는 비용
    static List<Cost>[] adj; // adj[i]: i와 연결된 도시
    static final int INF = 100000001;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        PriorityQueue<Cost> pq = new PriorityQueue<>(new Comparator<Cost>() {
            @Override
            public int compare(Cost o1, Cost o2) {
                return o1.value - o2.value;
            }
        });

        // 초기화
        // 모든 도시로 향하는 cost를 INF, start로 향하는 cost를 0으로 초기화한다.
        Arrays.fill(cost, INF);
        cost[A] = 0;
        pq.add(new Cost(A, 0));

        while (!pq.isEmpty()) {
            // 가장 짧은 거리의 도시를 찾는다.
            Cost c = pq.poll();

            // 최신 정보와 다르면 무시한다.
            if (c.value != cost[c.x]) continue;

            // 뽑은 도시와 연결된 도시들의 거리를 업데이트한다.
            for (Cost y : adj[c.x]) {
                if (cost[y.x] > cost[c.x] + y.value) {
                    cost[y.x] = cost[c.x] + y.value;
                    pq.add(new Cost(y.x, cost[y.x]));
                }
            }
        }
        System.out.println(Arrays.toString(cost));
        System.out.println(cost[B]);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cost = new int[N + 1];
        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new LinkedList<Cost>();
        }
        for (int i = 0; i < M; i++) {
            String str[] = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            adj[x].add(new Cost(y, cost));
        }
        String str[] = br.readLine().split(" ");
        A = Integer.parseInt(str[0]);
        B = Integer.parseInt(str[1]);
    }
}
