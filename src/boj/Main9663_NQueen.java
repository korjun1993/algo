package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663_NQueen {
	static int n;
	static int answer;
	static boolean[][] board;

	public static void solve(int row) {
		if (row >= n) {
			answer++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (available(row, col)) {
				board[row][col] = true;
				solve(row + 1);
				board[row][col] = false;
			}
		}
	}

	private static boolean available(int row, int col) {
		if (row == 0) {
			return true;
		}

		for (int i = 1; i <= row; i++) {
			if (board[row - i][col]) {
				return false;
			}
			if (i <= col && board[row - i][col - i]) {
				return false;
			}
			if (col + i < n && board[row - i][col + i]) {
				return false;
			}
		}
		return true;
	}

	public static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			board = new boolean[n][n];
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		input();
		solve(0);
		System.out.println(answer);
	}
}
