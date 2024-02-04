package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visit;
	static int[][] bridges;
	static int[] parent;
	static int answer;
	static int cnt; // 섬의 개수

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class Bridge implements Comparable<Bridge> {
		int v1, v2, w;

		public Bridge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;

		input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visit[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}

		bridges = new int[cnt + 1][cnt + 1];
		parent = new int[cnt + 1];

		for (int i = 0; i <= cnt; i++) {
			Arrays.fill(bridges[i], Integer.MAX_VALUE);
			parent[i] = i;
		}

		makeBridge();

		kruskal();
		System.out.println(answer > 0 && cnt == 1 ? answer : -1);
	}

	private static void kruskal() {
		List<Bridge> list = new LinkedList<>();

		for (int i = 0; i <= cnt; i++) {
			for (int j = 0; j <= cnt; j++) {
				if (bridges[i][j] != Integer.MAX_VALUE) {
					list.add(new Bridge(i, j, bridges[i][j]));
				}
			}
		}

		Collections.sort(list);

		for (Bridge b : list) {
			if (!isEqual(b)) {
				answer += b.w;
				union(b);
				cnt--;
			}
		}
	}

	private static int findParent(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findParent(parent[x]);
	}

	private static boolean isEqual(Bridge b) {
		return findParent(b.v1) == findParent(b.v2);
	}

	private static void union(Bridge b) {
		int parentX = findParent(b.v1);
		int parentY = findParent(b.v2);
		int p = Integer.min(parentX, parentY);
		parent[parentX] = parent[parentY] = p;
	}

	static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();

		visit[y][x] = true;
		map[y][x] = cnt;
		queue.offer(new Node(y, x));

		Node out;
		int nextX, nextY;

		while (!queue.isEmpty()) {

			out = queue.poll();

			for (int i = 0; i < 4; i++) {
				nextY = out.y + dy[i];
				nextX = out.x + dx[i];

				if (nextY >= 0 && nextX >= 0 && nextY < N && nextX < M && !visit[nextY][nextX]
					&& map[nextY][nextX] != 0) {
					visit[nextY][nextX] = true;
					map[nextY][nextX] = cnt;
					queue.add(new Node(nextY, nextX));
				}
			}
		}
	}

	static void makeBridge() {
		int start, end, water;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				start = map[i][j];

				if (start != 0) {
					water = 0;

					for (int k = j + 1; k < M; k++) {
						end = map[i][k];
						if (end == 0) {
							water++;
						} else {
							if (water >= 2) {
								bridges[start][end] = Integer.min(water, bridges[start][end]);
							}
							break;
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				start = map[i][j];

				if (start != 0) {
					water = 0;

					for (int k = i + 1; k < N; k++) {
						end = map[k][j];
						if (end == 0) {
							water++;
						} else {
							if (water >= 2) {
								bridges[start][end] = Integer.min(water, bridges[start][end]);
							}
							break;
						}
					}
				}

			}
		}
	}
}
