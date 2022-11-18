package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main14938_서강그라운드 {
    static int INF = 1501;
    static int n, m, r, ans;
    static int items[];
    static int dist[];
    static List<Edge>[] edges;

    public static void main(String[] args) {
        input();
        pro();
    }

    /**
     * 각 지점을 출발지로 설정하여 dijkstra를 실행
     * 모든 곳으로의 최단 경로를 계산
     * 임의의 지점으로 가는 거리가 수색 범위 이내라면 해당 지점의 아이템수를 얻는다.
     */
    private static void pro() {
        for (int v = 1; v <= n; v++) {
            dijkstra(v);
            ans = Math.max(ans, IntStream.rangeClosed(1, n).filter(index -> dist[index] <= m).map(index -> items[index]).sum());
        }
        System.out.println(ans);
    }

    private static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화
        for (int i = 1; i <= n; i++) dist[i] = INF;

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보를 기록에 추가하고, 거리 배열 갱신하기
        pq.offer(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.v] < info.dist) continue;
            for (Edge e : edges[info.v]) {
                if (dist[info.v] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.v] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            r = Integer.parseInt(str[2]);
            items = new int[n + 1];
            dist = new int[n + 1];
            edges = new List[n + 1];
            str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                items[i + 1] = Integer.parseInt(str[i]);
                edges[i + 1] = new LinkedList<>();
            }
            for (int i = 0; i < r; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                int cost = Integer.parseInt(str[2]);
                edges[x].add(new Edge(y, cost));
                edges[y].add(new Edge(x, cost));
            }
        } catch (Exception ignored) {
        }
    }

    private static class Info {
        int v, dist;

        public Info(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    private static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
