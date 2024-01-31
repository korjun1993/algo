package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main16234_인구이동 {

	static class Node {
		int y, x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int ANSWER;
	static int N, L, R;
	static int[][] A;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visit;
	static boolean end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;

		input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		A = new int[N][];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		while (true) {

			end = true;

			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], false);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(i, j);
					}
				}
			}

			if (end) {
				System.out.println(ANSWER);
				break;
			}

			ANSWER++;
		}
	}

	static private void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		LinkedList<Node> list = new LinkedList<>();

		queue.add(new Node(y, x));
		list.add(new Node(y, x));

		visit[y][x] = true;

		Node temp, node;
		int ny, nx, sub, sum, avg;
		sum = A[y][x];

		while (!queue.isEmpty()) {
			temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				ny = temp.y + dy[i];
				nx = temp.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
					continue;
				}

				sub = Math.abs(A[temp.y][temp.x] - A[ny][nx]);

				if (L <= sub && sub <= R) {
					visit[ny][nx] = true;
					node = new Node(ny, nx);
					queue.offer(node);
					list.add(node);
					sum += A[ny][nx];
					end = false;
				}
			}
		}

		if (list.size() > 1) {
			avg = sum / list.size();
			for (Node n : list) {
				A[n.y][n.x] = avg;
			}
		}
	}
}
