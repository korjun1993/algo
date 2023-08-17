package codetree.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class K번최댓값으로이동하기 {
	public static int n, k, r, c;
	public static int[][] board;
	public static boolean[][] visited;

	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		board = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;

		while (k-- > 0) {
			if(!move()) {
				break;
			}
		}

		System.out.println((r + 1) + " " + (c + 1));
	}

	public static boolean move() {
		// step1 - 갈 수 있는 곳 중 최대값을 찾아낸다
		int maxValue = findCand();

		// step1.1 - 갈 수 있는 곳이 없다면 종료한다.
		if (maxValue == 0) {
			return false;
		}

		// step2 - 행 번호가 가장 낮은 곳, 열 번호가 가장 작은 곳을 찾아낸다.
		Pair target = findTarget(maxValue);

		// step3 - 위치를 업데이트 한다.
		r = target.x;
		c = target.y;

		return true;
	}

	public static int findCand() {
		int result = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		initVisited();
		visited[r][c] = true;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(r, c));

		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (cantGo(nx, ny)) {
					continue;
				}
				visited[nx][ny] = true;
				queue.offer(new Pair(nx, ny));
				result = Math.max(result, board[nx][ny]);
			}
		}
		return result;
	}

	public static void initVisited() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}

	public static boolean cantGo(int x, int y) {
		return isOut(x, y) || visited[x][y] || board[x][y] >= board[r][c];
	}

	public static boolean isOut(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}

	public static Pair findTarget(int value) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] && board[i][j] == value) {
					return new Pair(i, j);
				}
			}
		}

		return null;
	}
}
