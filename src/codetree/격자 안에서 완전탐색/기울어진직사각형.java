package codetree.격자안에서밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 기울어진직사각형 {
	public static int[][] d = {{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
	public static int answer;
	public static int n;
	public static int[][] board = new int[20][20];

	public static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(str[j]);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int solve(int x, int y, int width, int height) {
		int result = 0;

		for (int i = 0; i < 4; i++) {
			int limit = (i % 2 == 0) ? width : height;
			for (int j = 0; j < limit; j++) {
				x += d[i][0];
				y += d[i][1];
				if (x >= n || x < 0 || y >= n || y < 0) {
					return 0;
				}
				result += board[x][y];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		input();
		for (int width = 1; width <= n; width++) {
			for(int height = 1; height <= n; height++) {
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						answer = Math.max(answer, solve(x, y, width, height));
					}
				}
			}
		}

		System.out.println(answer);
	}
}

