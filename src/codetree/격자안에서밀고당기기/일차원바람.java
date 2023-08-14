package codetree.격자안에서밀고당기기;

import java.util.Scanner;

public class 일차원바람 {
	public static class Wind {
		int x;
		char d;
	}

	public static int n, m, q;
	public static Wind[] winds;
	public static int[][] board = new int[100][100];

	public static void input() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		q = sc.nextInt();
		winds = new Wind[q];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < q; i++) {
			Wind wind = new Wind();
			wind.x = sc.nextInt() - 1;
			wind.d = sc.next().charAt(0);
			winds[i] = wind;
		}
	}

	public static void circuit(int x, char d) {
		if (d == 'L') {
			int temp = board[x][m - 1];
			for (int i = m - 2; i >= 0; i--) {
				board[x][i + 1] = board[x][i];
			}
			board[x][0] = temp;
		} else if(d == 'R') {
			int temp = board[x][0];
			for (int i = 0; i < m - 1; i++) {
				board[x][i] = board[x][i + 1];
			}
			board[x][m - 1] = temp;
		}
	}

	public static boolean check(int x1, int x2) {
		if (x2 < 0 || x2 >= n) {
			return false;
		}

		for (int i =0; i < m; i++) {
			if(board[x1][i] == board[x2][i]) {
				return true;
			}
		}

		return false;
	}

	public static void doProcess(int x, char d) {
		circuit(x, d);
		char cur_d = d;
		for (int x2 = x - 1; x2 >= 0; x2--) {
			cur_d = (cur_d == 'L') ? 'R' : 'L';
			if (!check(x2 + 1, x2)) {
				break;
			}
			circuit(x2, cur_d);
		}
		cur_d = d;
		for (int x2 = x + 1; x2 < n; x2++) {
			cur_d = (cur_d == 'L') ? 'R' : 'L';
			if (!check(x2 - 1, x2)) {
				break;
			}
			circuit(x2, cur_d);
		}
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solve() {
		for (int i = 0; i < q; i++) {
			doProcess(winds[i].x, winds[i].d);
		}
		print();
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}
