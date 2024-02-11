package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1012_유기농배추 {

	public static int M, N, K, T, Answer;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static String[] s;
	public static boolean[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]); // 가로
			N = Integer.parseInt(s[1]); // 세로
			K = Integer.parseInt(s[2]); // 배추

			map = new boolean[N][M];
			Answer = 0;

			int row, col;


			for (int i = 0; i < K; i++) {
				s = br.readLine().split(" ");
				col = Integer.parseInt(s[0]); // 가로
				row = Integer.parseInt(s[1]); // 세로
				map[row][col] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]) {
						bfs(i, j);
						Answer++;
					}
				}
			}

			sb.append(Answer).append("\n");
		} // test_case
		System.out.println(sb);
		br.close();
	} // main

	private static void bfs(int row, int col) {
		Queue<Pos> queue = new LinkedList<>();

		queue.offer(new Pos(row, col));
		map[row][col] = false;

		Pos temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = temp.y + dy[i];
				int nextCol = temp.x + dx[i];

				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && map[nextRow][nextCol]) {
					map[nextRow][nextCol] = false;
					queue.offer(new Pos(nextRow, nextCol));
				}
			}
		}
	}

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
