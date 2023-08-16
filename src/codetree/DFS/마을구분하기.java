package codetree.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 마을구분하기 {
	public static int n;
	public static int count;
	public static int[][] board;
	public static boolean[][] visited;
	public final static int WALL = 0;
	public final static int[] dx = {-1, 1, 0, 0};
	public final static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != WALL && !visited[i][j]) {
					count = 1;
					visited[i][j] = true;
					dfs(i, j);
					answer.add(count);
				}
			}
		}

		Collections.sort(answer);

		System.out.println(answer.size());
		for (int i : answer) {
			System.out.println(i);
		}
	}

	public static boolean canGo(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < n) && !visited[x][y] && board[x][y] != WALL;
	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (canGo(nx, ny)) {
				visited[nx][ny] = true;
				count++;
				dfs(nx, ny);
			}
		}
	}
}
