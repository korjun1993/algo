package codetree.격자안에서밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 양수직사각형의최대크기 {
	public static int n, m;
	public static int[][] board = new int[20][20];

	public static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str[] = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					board[i][j] = Integer.parseInt(str[j]);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean checkPositive(int x1, int y1, int x2, int y2) {
		for (int x = x1; x <= x2; x++) {
			for (int y = y1; y <= y2; y++) {
				if (board[x][y] <= 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static int findMax(int x1, int y1, int x2, int y2) {
		if (checkPositive(x1, y1, x2, y2)) {
			return (x2 - x1 + 1) * (y2 - y1 + 1);
		}
		return -1;
	}

	public static int solve() {
		int answer = -1;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				for (int l = x; l < n; l++) {
					for (int k = y; k < m; k++) {
						answer = Math.max(answer, findMax(x, y, l, k));
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		input();
		int answer = solve();
		System.out.println(answer);
	}
}
