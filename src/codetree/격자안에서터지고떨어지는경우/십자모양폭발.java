package codetree.격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class 십자모양폭발 {
	public static int n;
	public static int[][] board;
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		int r = sc.nextInt();
		int c = sc.nextInt();

		bomb(r, c);

		// 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// (r, c) 위치의 폭탄을 터트리는 함수
	public static void bomb(int r, int c) {
		// 폭탄을 터트린다
		explosive(r - 1, c - 1);

		// 중력을 작용한다
		down();
	}

	public static void explosive(int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int size = board[x][y];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 4; j++) {
				int nx = x + i * dx[j];
				int ny = y + i * dy[j];
				if (isOut(nx, ny)) {
					continue;
				}
				board[nx][ny] = 0;
			}
		}
	}

	public static boolean isOut(int x, int y) {
		return x < 0 || x >= n || y < 0 || y >= n;
	}

	public static int[][] copyArray(int[][] arr) {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j]= arr[i][j];
			}
		}
		return temp;
	}

	// 중력을 작용하는 함수
	public static void down() {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			int endOfArray = n - 1;
			for (int j = n - 1; j >= 0; j--) {
				if (board[j][i] != 0) {
					temp[endOfArray--][i] = board[j][i];
				}
			}
		}

		board = copyArray(temp);
	}
}
