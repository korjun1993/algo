package codetree.백트래킹;

import java.util.Scanner;

public class 강력한폭발 {
	public static int n, m, answer;
	public static int[] numbers;
	public static int[][] board;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 1) {
					m++;
				}
			}
		}
		numbers = new int[m];

		choose(0);
	}

	public static void choose(int curNum) {
		if (curNum == m) {
			answer = Math.max(answer, bomb());
			return;
		}
		for (int i = 0; i < 3; i++) {
			numbers[curNum] = i;
			choose(curNum + 1);
		}
	}

	public static int bomb() {
		int index = 0;
		boolean[][] isExplosive = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					explosive(i, j, numbers[index++], isExplosive);
				}
			}
		}
		return (count(isExplosive));
	}

	public static void explosive(int x, int y, int kind, boolean[][] isExplosive) {
		int[][][] dir = {
			{{-1, -2, 1, 2}, {0, 0, 0, 0}},
			{{-1, 1, 0, 0}, {0, 0, -1, 1}},
			{{-1, -1, 1, 1}, {-1, 1, -1, 1}}
		};

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[kind][0][i];
			int ny = y + dir[kind][1][i];
			if (isOut(nx, ny)) {
				continue;
			}
			isExplosive[nx][ny] = true;
		}
	}

	public static int count(boolean[][] isExplosive) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (isExplosive[i][j]) {
					result++;
				}
			}
		}
		return result;
	}

	public static boolean isOut(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}
}
