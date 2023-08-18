package codetree.DP;

import java.util.Scanner;

public class 정수사각형최장증가수열 {
	public static int n, answer;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] board;
	public static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer = Math.max(answer, dfs(i, j));
			}
		}

		System.out.println(answer);
	}

	// (i, j)에서 출발하여 칸에 적혀있는 정수값이 커지도록
	// 상하좌우 인접한 칸으로 이동할 때
	// 지나갈 수 있는 최대 칸의 수를 반환하는 함수
	public static int dfs(int x, int y) {

		// 이미 구한 적이 있다면 그대로 반환
		if (dp[x][y] > 0) {
			return dp[x][y];
		}

		// 인접한 곳 중 이동할 수 있는 공간이 있는지 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isOut(nx, ny)) {
				continue;
			}
			if (board[nx][ny] <= board[x][y]) {
				continue;
			}
			dp[x][y] = Math.max(dp[x][y], dfs(nx, ny));
		}

		dp[x][y] += 1; // 자신도 밟을 수 있으므로 +1
		return dp[x][y];
	}

	public static boolean isOut(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}
}
