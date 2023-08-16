package codetree.DFS;

import java.util.Scanner;

public class 두방향탈출가능여부판단하기 {
	public static int n, m;
	public static int[][] board;
	public static boolean[][] visited;
	public static int[][] dir = {{1, 0}, {0, 1}};

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		visited[0][0] = true;
		dfs(0, 0);

		int answer = visited[n - 1][m - 1] ? 1 : 0;

		System.out.println(answer);
	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < 2; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			if (board[nx][ny] == 0) {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
