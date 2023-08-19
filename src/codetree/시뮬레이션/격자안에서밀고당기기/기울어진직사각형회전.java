package codetree.시뮬레이션.격자안에서밀고당기기;

import java.util.Scanner;

public class 기울어진직사각형회전 {
	public static int n;
	public static int r, c, m1, m2, m3, m4, dir;
	public static int[][] board;

	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		r = sc.nextInt() - 1;
		c = sc.nextInt() - 1;
		m1 = sc.nextInt();
		m2 = sc.nextInt();
		m3 = sc.nextInt();
		m4 = sc.nextInt();
		dir = sc.nextInt();
	}

	public static void shiftLeft() {
		int x = r;
		int y = c;
		int temp = board[r][c];
		for (int i = 0; i < m4; i++) {
			board[x][y] = board[x - 1][y - 1];
			x--;
			y--;
		}
		for (int i = 0; i < m3; i++) {
			board[x][y] = board[x - 1][y + 1];
			x--;
			y++;
		}
		for (int i = 0; i < m2; i++) {
			board[x][y] = board[x + 1][y + 1];
			x++;
			y++;
		}
		for (int i = 0; i < m1; i++) {
			board[x][y] = board[x + 1][y - 1];
			x++;
			y--;
		}
		board[r - 1][c + 1] = temp;
	}

	public static void shiftRight() {
		int x = r;
		int y = c;
		int temp = board[r][c];
		for (int i = 0; i < m1; i++) {
			board[x][y] = board[x - 1][y + 1];
			x--;
			y++;
		}
		for (int i = 0; i < m2; i++) {
			board[x][y] = board[x - 1][y - 1];
			x--;
			y--;
		}
		for (int i = 0; i < m3; i++) {
			board[x][y] = board[x + 1][y - 1];
			x++;
			y--;
		}
		for (int i = 0; i < m4; i++) {
			board[x][y] = board[x + 1][y + 1];
			x++;
			y++;
		}
		board[r - 1][c - 1] = temp;
	}

	public static void solve() {
		if (dir == 0) { // 반시계 방향
			shiftLeft();
			return;
		}

		// 시계 방향
		shiftRight();
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		input();
		solve();
		print();
	}
}
