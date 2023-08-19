package codetree.시뮬레이션.격자안에서밀고당기기;

import java.util.Scanner;

public class 이차원바람 {
	public static int n, m, q;
	public static int[][] board;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		while (q-- > 0) {
			int r1 = sc.nextInt() - 1;
			int c1 = sc.nextInt() - 1;
			int r2 = sc.nextInt() - 1;
			int c2 = sc.nextInt() - 1;
			shift(r1, c1, r2, c2);
			avg(r1, c1, r2, c2);
		}

		// 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] copyArray(int[][] origin) {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = origin[i][j];
			}
		}
		return tmp;
	}

	private static void avg(int r1, int c1, int r2, int c2) {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int[][] tmp = copyArray(board);
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int sum = board[i][j];
				int cnt = 1;
				for (int k = 0; k < 4; k++) {
					int nx = i + dir[k][0];
					int ny = j + dir[k][1];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					sum += board[nx][ny];
					cnt += 1;
				}
				tmp[i][j] = sum / cnt;
			}
		}
		board = tmp;
	}

	private static void shift(int r1, int c1, int r2, int c2) {
		int temp = board[r1][c1];

		// 좌측 상단(r1, c1) -> 좌측 하단(r2, c1) shift
		for (int i = r1; i < r2; i++) {
			board[i][c1] = board[i + 1][c1];
		}

		// 좌측 하단(r2, c1) <- 우측 하단(r2, c2) shift
		for (int i = c1; i < c2; i++) {
			board[r2][i] = board[r2][i + 1];
		}

		// 우측 하단(r2, c2) <- 우측 상단(r1, c2) shift
		for (int i = r2; i > r1; i--) {
			board[i][c2] = board[i - 1][c2];
		}

		// 좌측 상단(r1, c1) <- 우측 상단(r1, c2) shift
		for (int i = c2; i > c1; i--) {
			board[r1][i] = board[r1][i - 1];
		}

		board[r1][c1 + 1] = temp;
	}
}
