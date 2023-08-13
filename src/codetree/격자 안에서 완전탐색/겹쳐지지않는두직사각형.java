package codetree.격자안에서밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 겹쳐지지않는두직사각형 {
	public static final int FAIL = -50000;
	public static int n, m;
	public static int[][] board = new int[5][5];

	public static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					board[i][j] = Integer.parseInt(str[j]);
				}
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int solve(int x, int y, int width, int height, boolean[][] visit) {
		int sum = 0;
		visit[x][y] = true;
		for (int i = x; i <= x + width; i++) {
			for (int j = y; j < y + height; j++) {
				if (i >= n || i < 0 || j >= m || j < 0 || visit[i][j]) {
					return FAIL;
				}
				visit[i][j] = true;
				sum += board[i][j];
			}
		}
		return sum;
	}

	public static boolean[][] copyArray(boolean[][] arr) {
		boolean[][] copy = new boolean[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				copy[i][j] = arr[i][j];
			}
		}
		return copy;
	}

	public static void main(String[] args) {
		input();
		int answer = FAIL;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				for (int width = 0; width < n; width++) {
					boolean[][] visit = new boolean[n][m];
					for (int height = 0; height < m; height++) {
						int square1 = solve(x, y, width, height, visit);
						if (square1 != FAIL) {
							for (int x2 = 0; x2 < n; x2++) {
								for (int y2 = 0; y2 < m; y2++) {
									for(int width2 = 0; width2 < n; width2++) {
										for (int height2 = 0; height2 < m; height2++) {
											boolean[][] visit2 = copyArray(visit);
											if (!visit2[x2][y2]) {
												int square2 = solve(x2, y2, width2, height2, visit2);
												if (square2 != FAIL) {
													answer = Math.max(answer, square1 + square2);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
