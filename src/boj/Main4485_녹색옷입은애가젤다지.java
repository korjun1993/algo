package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main4485_녹색옷입은애가젤다지 {
	static int testno = 1;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n;
	static int[][] board;
	static List<E>[] edges;

	static class E {
		int idx, cost;

		public E(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void dijkstra() {
		// board를 기반으로 edges 초기화
		edges = new List[n * n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int r = i + dir[k][0];
					int c = j + dir[k][1];
					if (r < 0 || c < 0 || r >= n || c >= n) {
						continue;
					}
					int from = i * n + j;
					int to = r * n + c;
					if (edges[from] == null) {
						edges[from] = new ArrayList<>();
					}
					edges[from].add(new E(to, board[r][c]));
				}
			}
		}

		// dijkstra 준비
		int[] dist = new int[n * n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = board[0][0];

		PriorityQueue<E> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
		pq.add(new E(0, board[0][0]));

		// dijkstra 수행
		while (!pq.isEmpty()) {
			E e = pq.poll();

			if (dist[e.idx] < e.cost) {
				continue;
			}

			// e.cost로 최단거리 최신화
			for (E near : edges[e.idx]) {
				int newdist = e.cost + near.cost;
				if (newdist < dist[near.idx]) {
					dist[near.idx] = newdist;
					pq.add(new E(near.idx, newdist));
				}
			}
		}

		System.out.println("Problem " + testno++ + ": " + dist[n * n - 1]);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				n = Integer.parseInt(br.readLine());

				if (n == 0) {
					break;
				}

				input(br);
				dijkstra();
			} catch (IOException e) {
			}
		}
	}

	private static void input(BufferedReader br) throws IOException {
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(str[j]);
			}
		}
	}
}
