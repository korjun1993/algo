package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1916_최소비용구하기 {
	public static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	public static class Info {
		int idx, dist;

		public Info(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
	public static int n, m;
	public static int[] dist;
	public static List<Edge>[] graph;
	public static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new List[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int c = sc.nextInt();
			graph[x].add(new Edge(y, c));
		}

		int start = sc.nextInt();
		int end = sc.nextInt();

		dijkstra(start, end);

		System.out.println(dist[end]);
	}

	private static void dijkstra(int start, int end) {
		for (int i = 1; i <= n; i++) {
			dist[i] = INF;
		}

		dist[start] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(i-> i.dist));
		pq.add(new Info(start, 0));

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			// 꺼낸 정보가 최신 거리 정보보다 크다면 의미없는 정보이므로 버린다.
			if (dist[info.idx] < info.dist) continue;

			// 뽑은 도시와 연결된 도시들의 거리를 업데이트한다.
			for (Edge e : graph[info.idx]) {
				if (dist[info.idx] + e.cost >= dist[e.to]) continue;
				dist[e.to] = info.dist + e.cost;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
}
